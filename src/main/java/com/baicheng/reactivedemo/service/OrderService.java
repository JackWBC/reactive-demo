package com.baicheng.reactivedemo.service;

import com.baicheng.reactivedemo.model.CoffeeOrder;
import com.baicheng.reactivedemo.repository.CoffeeOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author baicheng
 * @description
 * @create 2019-03-17 15:37
 */
@Service
@Slf4j
public class OrderService {

    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;

    public Mono<Long> create(CoffeeOrder order){
        return coffeeOrderRepository.save(order);
    }
}
