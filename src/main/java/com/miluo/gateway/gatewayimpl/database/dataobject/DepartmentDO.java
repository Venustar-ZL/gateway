package com.miluo.gateway.gatewayimpl.database.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author ：Mark.Wei
 * @description：部门
 * @date ：2021/8/17 10:23 *
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="sd_department")
public class DepartmentDO extends BaseDO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="code",nullable = false)
    private String code;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="sequence",nullable = false)
    private Integer sequence;

    @Column(name="enabled")
    private Boolean enabled;

    @Column(name="parent_id")
    private Long parentId;
}
