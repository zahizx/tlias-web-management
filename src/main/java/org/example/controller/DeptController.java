package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Dept;
import org.example.pojo.Result;
import org.example.anno.Log;
import org.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 **/
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    //注入
    @Autowired
    //定义接口方法
    private DeptService deptService;

    /**
     * 查询部门数据
     */
    //请求方式为GET
    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");

        //调用service查询部门数据
        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }

    /**
     * 根据id删除部门
     */
    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) throws Exception {
        log.info("根据id删除部门：{}", id);
        //调用delete删除部门
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门
     */
    @Log
    @PostMapping
    public Result insert(@RequestBody Dept dept) {
        log.info("新增部门：{}", dept);
        //调用insert新增部门
        deptService.insert(dept);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("查询到id为：{}的信息", id);
        //调用getById查询部门
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    /**
     * 修改部门
     */@Log
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改{}的信息", dept);
        //调用update修改部门
        deptService.update(dept);
        return Result.success();
    }
}
