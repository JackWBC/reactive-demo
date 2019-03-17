package com.baicheng.reactivedemo.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.joda.money.Money;

import java.io.IOException;

/**
 * @author baicheng
 * @description
 * @create 2019-03-16 23:05
 */
public class MoneySerializer extends StdSerializer<Money> {
    private static final long serialVersionUID = 1894802411233345415L;

    protected MoneySerializer() {
        super(Money.class);
    }

    @Override
    public void serialize(Money money, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(money.getAmountMinorLong());
    }
}
