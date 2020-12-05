package org.hqf.tutorials.java.flow.dto;

import lombok.Data;

/**
 * @author hqf
 * @date 2020/12/02
 */
@Data
public class BaseResult<T> {
    private int code;

    private String msg;

    private T data;
}
