package com.baicheng.reactivedemo;

import com.baicheng.reactivedemo.model.Coffee;
import com.baicheng.reactivedemo.model.CoffeeOrder;
import com.baicheng.reactivedemo.model.OrderState;
import com.baicheng.reactivedemo.service.CoffeeService;
import com.baicheng.reactivedemo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

/**
 * @author baicheng
 * @description
 * @create 2019-03-17 15:40
 */
@Slf4j
@Component
public class SpringbucksRunner implements ApplicationRunner {

    @Autowired
    private CoffeeService coffeeService;
    @Autowired
    private OrderService orderService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        coffeeService.initCache()
                .then(
                        coffeeService.findOneCoffee("mocha")
                        .flatMap(
                                c -> {
                                    CoffeeOrder order = createOrder("Li Lei", c);
                                    return orderService.create(order);
                                }
                        ).doOnError(r -> log.error("error", r))
                ).subscribe(s -> log.info("create order {}", s));
        log.info("after subscribe");
        Thread.sleep(5000);
    }

    private CoffeeOrder createOrder(String customer, Coffee... items){
        return CoffeeOrder.builder()
                .customer(customer)
                .items(Arrays.asList(items))
                .state(OrderState.INIT)
                .createTime(new Date())
                .updateTime(new Date())
                .build();
    }
}
