package com.miluo.gateway.gatewayimpl.database.dao;

import com.miluo.gateway.gatewayimpl.database.dataobject.DepartmentDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ：Mark.Wei
 * @description：部门DAO
 * @date ：2021/8/17 10:34 *
 */
public interface DepartmentDao extends JpaRepository<DepartmentDO, Long>, JpaSpecificationExecutor<DepartmentDO> {

}
