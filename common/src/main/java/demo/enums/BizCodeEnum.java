package demo.enums;

import lombok.Getter;

public enum BizCodeEnum {
    /**
     * 通用操作码
     */
    OPS_REPEAT(110001, "重复操作"),

    ACCOUNT_UNLOGIN(250004, "账号未登录"),

    /**
     * 账号
     */
    ACCOUNT_UNREGISTER(250002,"账号不存在"),
    ACCOUNT_PWD_ERROR(250003, "账号或者密码错误"),

    ACCOUNT_NO_AUTHORITY(250004, "无权限");


    @Getter
    private String message;

    @Getter
    private int code;

    private BizCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
