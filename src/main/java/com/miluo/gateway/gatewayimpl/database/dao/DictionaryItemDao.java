package com.miluo.gateway.gatewayimpl.database.dao;

import com.miluo.gateway.gatewayimpl.database.dataobject.DictionaryItemDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ：Mark.Wei
 * @description：数据字典子表Dao
 * @date ：2021/8/19 9:58 *
 */
public interface DictionaryItemDao extends JpaRepository<DictionaryItemDO, Long>, JpaSpecificationExecutor<DictionaryItemDO> {

}
