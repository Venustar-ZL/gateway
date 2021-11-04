package com.miluo.gateway.config.security;

import com.miluo.gateway.gatewayimpl.database.dao.UserDao;
import com.miluo.gateway.gatewayimpl.database.dataobject.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author by ZhangLei
 * @date 2021/11/4 14:33
 */
@Slf4j
@Primary
@Service
public class MiluoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDO user = this.userDao.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("请输入正确的用户名");
        }

        Set<RoleDO> roles = user.getRoles();
        MiluoGrantedAuthority miluoGrantedAuthority = createMiluoGrantedAuthority(roles);
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return new MiluoUserDetails(user, accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(roles), miluoGrantedAuthority);
    }

    private static class SimpleGrantedAuthorityComparator implements Comparator<SimpleGrantedAuthority> {
        @Override
        public int compare(SimpleGrantedAuthority o1, SimpleGrantedAuthority o2) {
            return o1.equals(o2) ? 0 : -1;
        }
    }

    public Collection<? extends GrantedAuthority> getAuthorities(Set<RoleDO> roles) {
        Set<SimpleGrantedAuthority> authList = new TreeSet<>(new SimpleGrantedAuthorityComparator());
        for (RoleDO role : roles) {
            authList.addAll(getGrantedAuthorities(role));
        }
        return authList;
    }

    public static Set<SimpleGrantedAuthority> getGrantedAuthorities(RoleDO role) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(role.getName()));
        Set<PermissionPageDO> permissionPageDOSet = role.getPermissionPageDOSet();
        for (PermissionDO permission : permissionPageDOSet) {
            authorities.add(new SimpleGrantedAuthority(permission.getName()));
        }
        Set<PermissionUIDO> permissionUIDOSet = role.getPermissionUIDOSet();
        for (PermissionDO permission : permissionUIDOSet) {
            authorities.add(new SimpleGrantedAuthority(permission.getName()));
        }
        Set<PermissionApiDO> permissionApiDOSet = role.getPermissionApiDOSet();
        for (PermissionDO permission : permissionApiDOSet) {
            authorities.add(new SimpleGrantedAuthority(permission.getName()));
        }
        return authorities;
    }

    private MiluoGrantedAuthority createMiluoGrantedAuthority(Set<RoleDO> roles) {
        Set<String> pageAuthorities = new HashSet<>();
        Set<String> uiAuthorities = new HashSet<>();
        Set<String> apiAuthorities = new HashSet<>();
        Set<String> currentRoles = new HashSet<>();
        for (RoleDO role : roles) {
            currentRoles.add(role.getCode());
            pageAuthorities.addAll((role.getPermissionPageDOSet().stream().map(PermissionPageDO::getCode).collect(Collectors.toSet())));
            uiAuthorities.addAll(role.getPermissionUIDOSet().stream().map(PermissionUIDO::getCode).collect(Collectors.toSet()));
            apiAuthorities.addAll(role.getPermissionApiDOSet().stream().map(PermissionApiDO::getCode).collect(Collectors.toSet()));
        }
        return new MiluoGrantedAuthority(currentRoles,pageAuthorities,uiAuthorities,apiAuthorities);
    }
}
