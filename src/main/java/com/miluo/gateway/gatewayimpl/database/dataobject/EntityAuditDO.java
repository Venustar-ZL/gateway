package com.miluo.gateway.gatewayimpl.database.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * ClassName: DataAuditDO
 * Description:
 * date: 2021/10/13 13:20
 *
 * @author huzhenghui
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="sd_entity_audit")
public class EntityAuditDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="entity_name")
    private String entityName;

    @Column(name="table_name")
    private String tableName;

    @Column(name="entity_id")
    private String entityId;

    @Column(name="operator")
    private String operator;

    @Column(name="operate_time")
    private Date operateTime;

    @Column(name="modified_info")
    private String modifiedInfo;

    @Column(name="new_object")
    private String newObject;

    @Column(name="old_object")
    private String oldObject;


}
