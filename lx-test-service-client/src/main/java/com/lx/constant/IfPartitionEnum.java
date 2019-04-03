package com.lx.constant;

/**
 * Created by chenjiang on 2018/12/19.
 * <p>
 * 是否指定分区
 */

public enum IfPartitionEnum {
    是("0", "是"),
    否("1", "否");

    private String code;
    private String message;

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    IfPartitionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Boolean getByCode(final String code) {
        if (code.equals("") || code == null) {
            return false;
        }
        IfPartitionEnum[] values = IfPartitionEnum.values();
        for (IfPartitionEnum value : values) {
            if (value.code.equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }
}
