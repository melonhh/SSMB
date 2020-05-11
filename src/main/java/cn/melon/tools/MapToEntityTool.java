package cn.melon.tools;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapToEntityTool {
    /**
     * 将map类型变量转化为实体对象
     * @param map
     * @param entityClass
     * @param <T>
     * @return
     */
    public static <T> T map2entity(Map<String, Object> map, Class<T> entityClass) {
        // entityClass拿到参数传来的对象的属性名称List集合
        // entityClass拿到参数传来的对象的set方法Map集合
        List<String> allFieldList = new ArrayList<>();
        Map<String, Method> setMethodMap = new HashMap<>();
        Field[] allFields = entityClass.getDeclaredFields();
        String setMethodName;
        String fieldName;
        Method setMethod;
        for (Field field : allFields) {
            field.setAccessible(true);
            fieldName = field.getName();
            allFieldList.add(fieldName);
            setMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            try {
                setMethod = entityClass.getDeclaredMethod(setMethodName, field.getType());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
            setMethodMap.put(fieldName, setMethod);
        }

        // 把map里的值，放到entity对象里
        T entity;
        try {
            entity = entityClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        Object fieldVale;
        Method setM;
        Class<?>[] paramTypes;
        for (String strFieldName : allFieldList) {
            fieldVale = map.get(strFieldName);
            if (fieldVale == null)
                continue;
            setM = setMethodMap.get(strFieldName);
            if (setM == null)
                continue;
            paramTypes = setM.getParameterTypes();
            if(paramTypes == null || paramTypes.length>1) {
                continue;
            }
            if(paramTypes[0].isAssignableFrom(fieldVale.getClass())) {
                //一致
                try {
                    setM.invoke(entity, fieldVale);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }

        return entity;
    }

}
