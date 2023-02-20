import com.alibaba.excel.EasyExcel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExportTest {
    /**
     * 封装导出Excel所需的数据
     * @param: cls
     * @return java.util.List<com.chuenhung.bean.ExportData>
     * @author liquanhong
     * @date 2021/8/19
     */
    static List<ExportData> getExportData(Class cls, Map<String,String> doc){
        //1、 通过Java反射得到注解和属性信息
        Field[] fields = cls.getDeclaredFields();
        List<ExportData> exportDataList = new ArrayList<>();
        for(Field field: fields){
            // 属性类型
            String typeName = field.getGenericType().getTypeName();
            String tyNameNew = typeName.substring(typeName.lastIndexOf(".")+1);
            // 泛型值
            ApiModelProperty apiModelProperty = field.getAnnotation(ApiModelProperty.class);
            // ExportData数据
            ExportData data = new ExportData();
            data.setType(tyNameNew);
            data.setName(field.getName());
            data.setDescription(apiModelProperty.value());
            if(doc.containsKey(data.getName())){
                data.setDoc(doc.get(data.getName()));
            }
            exportDataList.add(data);
        }
        return exportDataList;
    }
}
