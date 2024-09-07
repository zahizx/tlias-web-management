package org.example.service;

import org.example.pojo.Dept;

import java.util.List;

public interface DeptService {

    /**
     * 查询全部部门数据
     */
    List<Dept> list();

    /**
     * 根据id删除部门
     */
    void delete(Integer id) throws Exception;

    /**
     * 新增部门
     */
    void insert(Dept dept);

    /**
     * 根据ID查询
     */
    Dept getById(Integer id);

    /**
     * 修改部门
     */
    void update(Dept dept);
}