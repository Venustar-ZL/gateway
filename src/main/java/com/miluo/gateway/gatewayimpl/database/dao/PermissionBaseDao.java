package com.miluo.gateway.gatewayimpl.database.dao;

import com.miluo.gateway.gatewayimpl.database.dataobject.PermissionDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Set;

/**
 * ClassName: PermissionBaseDao
 * Description:
 * date: 2021/8/5 11:31
 *
 * @author huzhenghui
 */
@NoRepositoryBean
public interface PermissionBaseDao<T extends PermissionDO> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

    /**
     * 根据权限代码集合查询权限列表
     * @param permissionCodeSet
     * @return
     */
    Set<PermissionDO> findByCodeIn(Set<String> permissionCodeSet);

}
