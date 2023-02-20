import com.alibaba.excel.EasyExcel;
import org.junit.Test;
import utils.DocUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class exportDocTest {
    @Test
    public void testPrintln()
    {
        //java源文件的路径
        ArrayList<String> sources=new ArrayList<>();
        //项目名开始的路径
        sources.add("E:/IDEA项目/exportJavaBean/src/main/java/Awards.java");
        //打印
        DocUtil.println(sources);
    }

    @Test
    public void testExport(){
        //java源文件的路径
        ArrayList<String> sources=new ArrayList<>();
        //项目名开始的路径
        sources.add("E:/IDEA项目/exportJavaBean/src/main/java/Awards.java");
        //获取doc
        Map<String, String> doc = DocUtil.getDoc(sources);
        // 1、封装导出Excel所需的数据
        List<ExportData> exportDataList = ExportTest.getExportData(Awards.class,doc);
        //2、 通过EasyExcel导出
        EasyExcel.write("exportJavaBean.xlsx", ExportData.class).sheet("JavaBean导出Excel表格").doWrite(exportDataList);

    }
}
