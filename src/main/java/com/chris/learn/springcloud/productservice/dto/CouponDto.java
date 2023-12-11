package com.chris.learn.springcloud.productservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CouponDto {
    private Long id;
    private String code;
    private String expDate;
    private BigDecimal discount;
}
