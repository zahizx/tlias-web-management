package org.example.service.impl;

import org.example.pojo.Dept;
import org.example.pojo.DeptLog;
import org.example.mapper.DeptMapper;
import org.example.mapper.EmpMapper;
import org.example.service.DeptLogService;
import org.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;

    //@MyLog1
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    //@Transactional(rollbackFor = Exception.class)//Spring事务管理,回滚所有异常
    //@MyLog1
    @Transactional
    @Override
    public void delete(Integer id) throws Exception {
        try {
            deptMapper.deleteById(id); //根据ID删除部门数据

            //int i = 1/0;
            //if(true){throw new Exception("出错啦...");}

            empMapper.deleteByDeptId(id); //根据部门ID删除该部门下的员工
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行了解散部门的操作,此次解散的是"+id+"号部门");
            deptLogService.insert(deptLog);
        }
    }

    @Override
    public void insert(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.update(dept);
    }
}
