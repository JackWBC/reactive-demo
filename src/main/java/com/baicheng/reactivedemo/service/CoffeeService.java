package com.baicheng.reactivedemo.service;

import com.baicheng.reactivedemo.model.Coffee;
import com.baicheng.reactivedemo.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author baicheng
 * @description
 * @create 2019-03-17 15:01
 */
@Service
@Slf4j
public class CoffeeService {

    private static final String PREFIX = "springbucks-";

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private ReactiveRedisTemplate<String, Coffee> reactiveRedisTemplate;

    public Flux<Boolean> initCache(){
        return coffeeRepository.findAll()
                .flatMap(item ->
                        reactiveRedisTemplate.opsForValue()
                        .set(PREFIX + item.getName(), item)
                        .flatMap(b -> reactiveRedisTemplate.expire(PREFIX + item.getName(), Duration.ofMinutes(1)))
                        .doOnSuccess(r -> log.info("Loading and Caching {}", item))
                );
    }

    public Mono<Coffee> findOneCoffee(String name){
        return reactiveRedisTemplate.opsForValue()
                .get(PREFIX + name)
                .switchIfEmpty(
                        coffeeRepository.findByName(name)
                        .doOnSuccess(r -> log.info("Loading {} from db", name))
                );
    }

}
