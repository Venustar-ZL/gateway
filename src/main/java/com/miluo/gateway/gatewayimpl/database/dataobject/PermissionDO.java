package com.miluo.gateway.gatewayimpl.database.dataobject;

import com.miluo.framework.constants.PermissonTypeEnum;
import lombok.*;

import javax.persistence.*;

/**
 * ClassName: PermissionDO
 * Description: PermissionDO
 * date: 2021/7/22 14:13
 *
 * @author huzhenghui
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(exclude = {"permissionUIDO","permissionPageDO","permissionApiDO"}, callSuper = false)
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="sd_permission")
public abstract class PermissionDO extends BaseDO {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 权限代码
     */
    @Column(name="code")
    private String code;

    /**
     * 权限名称
     */
    @Column(name="name")
    private String name;

    /**
     * 权限类型
     */
    @Enumerated(value = EnumType.STRING)
    @Column(name="type")
    private PermissonTypeEnum type;

    /**
     * 权限状态
     */
    @Column(name="status")
    private String status;

    /**
     * 复合权限代码
     */
    @Column(name="combined_code")
    private String combinedCode;

    /**
     * 备注
     */
    @Column(name="remark")
    private String remark;

    @ToString.Exclude
    @OneToOne
    @PrimaryKeyJoinColumn(name = "id",referencedColumnName = "id")
    protected PermissionUIDO permissionUIDO;

    @ToString.Exclude
    @OneToOne
    @PrimaryKeyJoinColumn(name = "id",referencedColumnName = "id")
    protected PermissionPageDO permissionPageDO;

    @ToString.Exclude
    @OneToOne
    @PrimaryKeyJoinColumn(name = "id",referencedColumnName = "id")
    protected PermissionApiDO permissionApiDO;

}
