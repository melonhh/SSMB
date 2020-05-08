package cn.melon.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BaseDao {

    Map<String, Object> queryOne(@Param("name") String name, @Param("id") int id);

    List<Map<Object, Object>> queryAll(@Param("name") String name);

    int add(@Param("name") String name, @Param("params") Object[] params);

    void update(@Param("id") int id, @Param("name") String name, @Param("params") Object[] params);

    void del(@Param("name") String name, @Param("id") int id);
}
