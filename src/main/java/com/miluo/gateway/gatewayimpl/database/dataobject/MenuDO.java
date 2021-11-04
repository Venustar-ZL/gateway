package com.miluo.gateway.gatewayimpl.database.dataobject;

import com.miluo.gateway.config.enums.MenuTypeEnum;
import lombok.*;

import javax.persistence.*;

/**
 * ClassName: MenuDO
 * Description: 菜单权限
 * date: 2021/7/22 17:11
 *
 * @author huzhenghui
 */
@Data
@ToString(callSuper = true,exclude = "permissionPageDO",doNotUseGetters = true)
@EqualsAndHashCode(exclude = {"permissionPageDO"}, callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="sd_menu")
public class MenuDO extends BaseDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 菜单编码
     */
    @Column(name="code")
    private String code;

    /**
     * 菜单名称
     */
    @Column(name="name")
    private String name;

    /**
     * 菜单path
     */
    @Column(name="path")
    private String path;

    /**
     * 类型
     */
    @Enumerated(value = EnumType.STRING)
    @Column(name="type")
    private MenuTypeEnum type;

    /**
     * 页面权限代码
     */
    @Column(name="accesss")
    private String accesss;

    /**
     * 父级菜单代码
     */
    @Column(name="parent_code")
    private String parentCode;

    /**
     * 相关页面权限
     */
    @OneToOne(mappedBy = "menuDO",targetEntity = PermissionPageDO.class, fetch = FetchType.LAZY)
    private PermissionPageDO permissionPageDO;


}
