package demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * @author xiao
 * @data 2024/4/2 22:01
 */

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser {
    /**
     * 主键
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 角色
     */
    private int role;
}
