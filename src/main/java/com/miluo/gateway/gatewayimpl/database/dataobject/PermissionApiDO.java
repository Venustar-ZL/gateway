package com.miluo.gateway.gatewayimpl.database.dataobject;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ClassName: ApiPermissionDO
 * Description:
 * date: 2021/8/3 14:12
 *
 * @author huzhenghui
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="sd_permission_api")
public class PermissionApiDO extends PermissionDO {

    /**
     * api 请求方法
     */
    @Column(name="method_type")
    private String methodType;

    /**
     * url匹配表达式
     */
    @Column(name="url_regex")
    private String urlRegex;

}
