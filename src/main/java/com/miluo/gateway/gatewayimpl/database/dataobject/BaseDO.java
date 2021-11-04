package com.miluo.gateway.gatewayimpl.database.dataobject;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * ClassName: BaseDO
 * Description:
 * date: 2021/8/5 15:57
 *
 * @author huzhenghui
 */

@MappedSuperclass
@Getter
@Setter
public class BaseDO {

    /**
     * 创建人
     */
    @Column(name="creator")
    @CreatedBy
    private String creator;

    /**
     * 修改人
     */
    @Column(name="modifier")
    @LastModifiedBy
    private String modifier;


    /**
     * 创建时间
     */
    @Column(name="create_time")
    @CreatedDate
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name="update_time")
    @LastModifiedDate
    private Date updateTime;
}
