package com.miluo.gateway.gatewayimpl.database.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author ：Mark.Wei
 * @description：字典项
 * @date ：2021/8/18 18:20 *
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="sd_dictionary_item")
public class DictionaryItemDO extends BaseDO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="code",length = 50,nullable = false)
    private String code;

    @Column(name="name",length = 100,nullable = false)
    private String name;

    @Column(name="value",nullable = false)
    private Integer value;

    @Column(name="sequence",nullable = false)
    private Integer sequence;

    @Column(name="dict_type_id",insertable = false,updatable = false)
    private Long dictionaryTypeId;

    @ManyToOne
    @JoinColumn(name="dict_type_id")
    private DictionaryTypeDO  dictionaryTypeDO;
}
