package com.miluo.gateway.gatewayimpl.database.dataobject;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * ClassName: PermissionMenuDO
 * Description:
 * date: 2021/8/11 9:51
 *
 * @author huzhenghui
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="sd_permission_page")
public class PermissionPageDO extends PermissionDO {

    @ToString.Exclude
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="menu_id",referencedColumnName="id")
    private MenuDO menuDO;

    @ToString.Exclude
    @OneToMany(mappedBy = "bindpermissionPageDO",targetEntity = PermissionUIDO.class,fetch = FetchType.EAGER)
    private List<PermissionUIDO> permissionUIDOList;


}
