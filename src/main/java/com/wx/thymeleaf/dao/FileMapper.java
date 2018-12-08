package com.wx.thymeleaf.dao;

import com.wx.thymeleaf.pojo.WxFile;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface FileMapper {
    @Insert("insert into user(name, age, addr) values(#{name}, #{age},#{addr})")
    int add(@Param("name") String name, @Param("age") Integer age, @Param("addr") String addr);

    @Update("update user set name = #{name}, age = #{age},addr=#{addr} where id = #{id}")
    int update(@Param("name") String name, @Param("age") Integer age,@Param("addr") String addr, @Param("id") int  id);

    @Delete("delete from user where id = #{id}")
    int delete(int id);

    @Select("select id, name as name, age as age ,addr as addr from user where id = #{id}")
    User findAccount(@Param("id") int id);

    @Select("SELECT id, fileName AS fileName, downStauts AS downStauts,fileupload.`describe` AS 'describe' FROM fileupload")
    List<WxFile> findFielList();
}
