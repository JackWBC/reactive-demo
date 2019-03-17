package com.baicheng.reactivedemo.converter;

import org.joda.money.Money;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

/**
 * @author baicheng
 * @description
 * @create 2019-03-17 15:06
 */
@WritingConverter
public class MoneyWriteConverter implements Converter<Money, Long> {

    @Override
    public Long convert(Money money) {
        return money.getAmountMinorLong();
    }
}
