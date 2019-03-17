package com.baicheng.reactivedemo.converter;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

/**
 * @author baicheng
 * @description
 * @create 2019-03-17 15:04
 */
@ReadingConverter
public class MoneyReadConverter implements Converter<Long, Money> {

    @Override
    public Money convert(Long aLong) {
        return Money.ofMinor(CurrencyUnit.of("CNY"), aLong);
    }
}
