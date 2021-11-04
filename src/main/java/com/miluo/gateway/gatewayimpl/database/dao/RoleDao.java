package com.miluo.gateway.gatewayimpl.database.dao;

import com.miluo.gateway.gatewayimpl.database.dataobject.RoleDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：Mark.Wei
 * @description：角色数据访问
 * @date ：2021/8/11 9:23 *
 */
public interface RoleDao extends JpaRepository<RoleDO, Long>, JpaSpecificationExecutor<RoleDO> {
    @Modifying
    @Transactional
    @Query("delete from RoleDO s where s.id in (?1)")
    void deleteAllByIds(List<Long> ids);
}
