package com.miluo.gateway.gatewayimpl.database.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @author ：Mark.Wei
 * @description：字典类型
 * @date ：2021/8/18 18:20 *
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="sd_dictionary_type")
public class DictionaryTypeDO extends BaseDO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="code",length = 50,nullable = false)
    private String code;

    @Column(name="name",length = 100,nullable = false)
    private String name;

    @Column(name="description")
    private String description;

    @OneToMany(targetEntity = DictionaryItemDO.class,cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name="dict_type_id")
    private List<DictionaryItemDO> dictionaryItems;
}
