package com.baicheng.reactivedemo.repository;

import com.baicheng.reactivedemo.model.Coffee;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.r2dbc.repository.query.Query;
import reactor.core.publisher.Mono;

/**
 * @author baicheng
 * @description
 * @create 2019-03-16 23:17
 */
public interface CoffeeRepository extends R2dbcRepository<Coffee, Long> {

    @Query("select * from t_coffee where name = $1")
    Mono<Coffee> findByName(String name);
}
