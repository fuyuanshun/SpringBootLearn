package com.fys.mapper;

import com.fys.model.Music;
import org.apache.ibatis.annotations.*;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *      Mybatis
 *      使用注解的方式
 */
@Component
@Mapper
public interface MusicMapper {

    @Insert("insert into music (name, link) values(#{name}, #{link})")
    int add(Music music);

    @Delete("delete from music where id = #{id}")
    int deleteById(Integer id);

    @Update("update music set name = #{name}, link = #{link} where id = #{id}")
    int update(Music music);

    @Select("select * from music")
    List<Music> selectAllMusic();

    @Select("select * from music where id = #{id}")
    Music selectMusicById(Integer id);

    @Select("select count(id) from music")
    int selectMusicCount();

    @Select("select * from music limit #{currentPage},#{pageSize}")
    List<Music> selectMusicByLimit(@Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);
}
