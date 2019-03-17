package com.baicheng.reactivedemo.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.io.IOException;

/**
 * @author baicheng
 * @description
 * @create 2019-03-16 23:07
 */
public class MoneyDeserializer extends StdDeserializer<Money> {
    private static final long serialVersionUID = 878590198519383783L;

    protected MoneyDeserializer() {
        super(Money.class);
    }

    @Override
    public Money deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        return Money.ofMinor(CurrencyUnit.of("CNY"), jsonParser.getLongValue());
    }
}
