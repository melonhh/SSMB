package cn.melon.service;

import cn.melon.dao.BaseDao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class BaseServiceImpl<T> implements BaseService<T>{
    private Class<?> clazz;
    private String tableName;

    /**
     * 获取BaseDao的实现对象
     * @return
     */
    public abstract BaseDao getBaseDao();


    public BaseServiceImpl() {
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] types = parameterizedType.getActualTypeArguments();
        clazz =(Class<?>) types[0];

        tableName = "t_" + clazz.getSimpleName().toLowerCase();
    }

    @Override
    public void add(T t) {
        List<Object> list = new ArrayList<>();

        for (Field field: t.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                list.add(field.get(t));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        getBaseDao().add(tableName,list.toArray());
    }

    @Override
    public void delete(int id) {
        getBaseDao().del(tableName,id);
    }

    @Override
    public void update(T t) {
        List<Object> list = new ArrayList<>();
        int id = 0;
        for(Field field : t.getClass().getDeclaredFields()){
            field.setAccessible(true);
            try {
                if(field.get(t) == null) {
                    continue;
                }
                if (field.getName().equals("id")){
                    id = (int) field.get(t);
                    continue;
                }
                list.add(field.getName() + "=" + field.get(t));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (id != 0) {
            getBaseDao().update(id, tableName, list.toArray());
        }
    }

    @Override
    public T select(int id) {
        Map<String, Object> rsList = getBaseDao().queryOne(tableName, id);

        // 把Map类型的值转化为类

        return null;
    }

    @Override
    public List<T> selectAll() {
        return null;
    }
}
