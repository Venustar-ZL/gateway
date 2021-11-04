package com.miluo.gateway.config.security;

import com.miluo.gateway.gatewayimpl.database.dataobject.UserDO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;

/**
 * @author by ZhangLei
 * @date 2021/11/4 13:52
 */
public class MiluoUserDetails implements UserDetails {

    private static final long serialVersionUID = -430318077330074506L;

    private String password;
    private String name;
    private boolean enabled;

    private Set<GrantedAuthority> authorities;

    private MiluoGrantedAuthority miluoGrantedAuthority;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public MiluoUserDetails() {
    }

    // TODO: 补全User
    public MiluoUserDetails(UserDO user, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
                            Collection<? extends GrantedAuthority> authorities, MiluoGrantedAuthority miluoGrantedAuthority) {

        if (user == null) {
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
        }

        this.userId = user.getId();
        this.name = user.getName();
        this.password = user.getPassword();

        this.enabled = true;
        this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
        this.miluoGrantedAuthority = miluoGrantedAuthority;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    private static SortedSet<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
        SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<>(new AuthorityComparator());

        for (GrantedAuthority grantedAuthority : authorities) {
            Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");
            sortedAuthorities.add(grantedAuthority);
        }
        return sortedAuthorities;
    }

    private static class AuthorityComparator implements Comparator<GrantedAuthority>, Serializable {

        private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

        @Override
        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
            if (g2.getAuthority() == null) {
                return -1;
            }
            if (g1.getAuthority() == null) {
                return 1;
            }

            return g1.getAuthority().compareTo(g2.getAuthority());
        }
    }

    public MiluoGrantedAuthority getMiluoGrantedAuthority() {
        return miluoGrantedAuthority;
    }

    public void setMiluoGrantedAuthority(MiluoGrantedAuthority miluoGrantedAuthority) {
        this.miluoGrantedAuthority = miluoGrantedAuthority;
    }
}
