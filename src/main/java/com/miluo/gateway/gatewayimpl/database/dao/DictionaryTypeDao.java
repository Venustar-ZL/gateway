package com.miluo.gateway.gatewayimpl.database.dao;

import com.miluo.gateway.gatewayimpl.database.dataobject.DictionaryTypeDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ：Mark.Wei
 * @description：TODO
 * @date ：2021/8/19 9:58 *
 */
public interface DictionaryTypeDao extends JpaRepository<DictionaryTypeDO, Long>, JpaSpecificationExecutor<DictionaryTypeDO> {

}
