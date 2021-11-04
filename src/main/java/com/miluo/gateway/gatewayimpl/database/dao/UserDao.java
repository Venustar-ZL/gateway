package com.miluo.gateway.gatewayimpl.database.dao;

import com.miluo.gateway.gatewayimpl.database.dataobject.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author ：Mark.Wei
 * @description：TODO
 * @date ：2021/7/20 14:49 *
 */
public interface UserDao extends JpaRepository<UserDO, Long>, JpaSpecificationExecutor<UserDO> {

    /**
     * 根据用户查询用户
     * @param name
     * @return
     */
    UserDO findByName(String name);
}
