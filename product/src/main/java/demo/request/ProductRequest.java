package demo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xiao
 * @data 2024/4/10 8:28
 */
@Getter
@Setter
@ApiModel(value = "产品对象",description = "产品请求对象")
public class ProductRequest {
    @ApiModelProperty(value = "id", example = "1")
    private int id;

    @ApiModelProperty(value = "名称", example = "xxx")
    private String name;
}
