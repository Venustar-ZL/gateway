package com.miluo.gateway.gatewayimpl.database.dao;

import com.miluo.gateway.gatewayimpl.database.dataobject.MenuDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * ClassName: MenuDao
 * Description:
 * date: 2021/8/18 13:22
 *
 * @author huzhenghui
 */
@Repository
public interface MenuDao extends JpaRepository<MenuDO, Long>, JpaSpecificationExecutor<MenuDO> {
}
