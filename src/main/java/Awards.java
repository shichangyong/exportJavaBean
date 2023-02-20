import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Awards {

    /**
     * id主键
     */
    @ApiModelProperty(value="id主键")
    private Long id;

    /**
     * awardType获奖类型：1双奖 2科技成果转化奖 3双创奖 4专利奖 5自主开发大赛奖 6在岗技术革新奖 7创客马拉松 8外部获奖"
     */
    @ApiModelProperty(value="awardType获奖类型：1双奖 2科技成果转化奖 3双创奖 4专利奖 5自主开发大赛奖 6在岗技术革新奖 7创客马拉松 8外部获奖")
    private Integer awardType;

    /**
     * topClass奖项等级-一级分类
     */
    @ApiModelProperty(value="topClass奖项等级-一级分类")
    private String topClass;

    /**
     * secondClass奖项等级-二级分类
     */
    @ApiModelProperty(value="secondClass奖项等级-二级分类")
    private String secondClass;

    /**
     * awardYear获奖年份：专利奖可为字符
     */
    @ApiModelProperty(value="awardYear获奖年份：专利奖可为字符")
    private String awardYear;

    /**
     * awardMoney成果奖金
     */
    @ApiModelProperty(value="awardMoney成果奖金")
    private BigDecimal awardMoney;

    /**
     * applyDate申请日
     */
    @ApiModelProperty(value="applyDate申请日")
    private Date applyDate;

    /**
     * createUser创建人
     */
    @ApiModelProperty(value="createUser创建人")
    private Integer createUser;
}
