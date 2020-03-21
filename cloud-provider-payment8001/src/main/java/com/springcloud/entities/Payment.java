package com.springcloud.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhigang.xu
 */
@Data
public class Payment implements Serializable {
    private Long id;

    private String serial;
}
