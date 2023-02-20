import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ExportData {

    @ExcelProperty(value="字段名",index = 0)
    private String name;
    @ExcelProperty(value="字段类型",index = 1)
    private String type;
    @ExcelProperty(value="字段说明",index = 2)
    private String description;
    @ExcelProperty(value="字段注释",index = 3)
    private String doc;
}
