package com.miluo.gateway.config.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

/**
 * @author by ZhangLei
 * @date 2021/11/4 14:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MiluoGrantedAuthority implements Serializable {

    private static final long serialVersionUID = -3554843880329905458L;

    private Set<String> roles;

    private Set<String> pageAuthorities;

    private Set<String> uiAuthorities;

    private Set<String> apiAuthorities;

}
