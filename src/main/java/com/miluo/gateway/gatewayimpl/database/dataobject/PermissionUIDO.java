package com.miluo.gateway.gatewayimpl.database.dataobject;

import com.miluo.gateway.config.enums.PermissionUIPatternEnum;
import lombok.*;

import javax.persistence.*;

/**
 * ClassName: UIPermissionDO
 * Description:
 * date: 2021/8/3 11:27
 *
 * @author huzhenghui
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="sd_permission_ui")
public class PermissionUIDO extends PermissionDO {

    @Enumerated(value = EnumType.STRING)
    @Column(name="pattern")
    private PermissionUIPatternEnum pattern;

    /**
     * 菜单权限id
     */
    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name="permission_page_id",referencedColumnName = "id")
    private PermissionPageDO bindpermissionPageDO;

}
