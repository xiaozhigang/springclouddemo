package demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiao
 * @data 2024/4/8 7:56
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
public class UserDO implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 昵称
     */
    private String name;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 角色
     */
    private String role;

    /**
     * 盐，用于个人敏感信息处理
     */
    private String secret;
}
