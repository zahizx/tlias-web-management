package org.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 **/
@Mapper
public interface DeptMapper {

    /**
     * 查询全部部门数据
     */
    @Select("select * from dept")
    List<Dept> list();

    /**
     * 根据id删除部门
     */
    @Delete("delete from dept where id=#{id}")
    void deleteById(Integer id);

    /**
     * 新增部门
     */
    @Insert("insert into dept (name, create_time, update_time) VALUE (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    /**
     * 根据ID查询
     */
    @Select("select * from dept where id=#{id}")
    Dept getById(Integer id);

    /**
     * 修改部门
     */
    /*@Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")*/
    void update(Dept dept);
}
