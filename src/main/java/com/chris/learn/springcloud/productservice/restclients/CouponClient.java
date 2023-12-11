package com.chris.learn.springcloud.productservice.restclients;

import com.chris.learn.springcloud.productservice.dto.CouponDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("coupon-service")
public interface CouponClient {
    @GetMapping("/api/coupons/{code}")
    CouponDto getCoupon(@PathVariable("code") String code);

}
