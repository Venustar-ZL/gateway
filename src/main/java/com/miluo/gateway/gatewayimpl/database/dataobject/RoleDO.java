package com.miluo.gateway.gatewayimpl.database.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

/**
 * ClassName: RoleDO
 * Description: RoleDO
 * date: 2021/7/22 13:55
 *
 * @author huzhenghui
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="sd_role")
public class RoleDO extends BaseDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="code")
    private String code;

    @Column(name="name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sd_permission_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    @JsonIgnore
    private Set<PermissionDO> permissionDOSet;

    /**
     * 页面权限
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sd_permission_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    @JsonIgnore
    private Set<PermissionPageDO> permissionPageDOSet;

    /**
     * 按钮权限
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sd_permission_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    @JsonIgnore
    private Set<PermissionUIDO> permissionUIDOSet;

    /**
     * api权限
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sd_permission_role",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    @JsonIgnore
    private Set<PermissionApiDO> permissionApiDOSet;
}
