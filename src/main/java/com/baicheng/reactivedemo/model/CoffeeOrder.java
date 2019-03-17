package com.baicheng.reactivedemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author baicheng
 * @description
 * @create 2019-03-16 23:12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeOrder implements Serializable {
    private static final long serialVersionUID = -5901721792385947040L;

    private Long id;

    private String customer;

    private OrderState state;

    private List<Coffee> items;

    private Date createTime;

    private Date updateTime;
}
