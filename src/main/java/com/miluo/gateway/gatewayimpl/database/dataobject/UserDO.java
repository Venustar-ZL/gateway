package com.miluo.gateway.gatewayimpl.database.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author ：Mark.Wei
 * @description：User
 * @date ：2021/7/20 13:55 *
 */
@Data
@ToString(exclude="roles")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="sd_user")
public class UserDO extends BaseDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable = false,unique = true)
    private String name;

    @Column(name="full_name")
    private String fullName;

    @Column(name="avatar_url")
    private String avatarUrl;

    @Column(name="password")
    @JsonIgnore
    private String password;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="email")
    private String email;

    @Column(name="department_id")
    private Long departmentId;

    @Column(name="enabled")
    private Boolean enabled;

    @Column(name="last_login_time")
    private Date lastLoginTime;

    @Column(name="last_logout_time")
    private Date lastLogoutTime;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "sd_role_user",
            joinColumns = @JoinColumn(name = "user_id") ,
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleDO> roles;
}
