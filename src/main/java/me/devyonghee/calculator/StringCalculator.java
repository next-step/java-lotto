package me.devyonghee.calculator;

import me.devyonghee.common.Assert;
import me.devyonghee.common.StringsProvider;

import java.util.Iterator;

final class StringCalculator {

    private final StringsProvider provider;

    private StringCalculator(StringsProvider provider) {
        Assert.notNull(provider, "'stringsProvider' must not be null");
        this.provider = provider;
    }

    static StringCalculator from(StringsProvider provider) {
        return new StringCalculator(provider);
    }

    Number calculatedNumber() {
        Iterator<String> iterator = provider.strings().iterator();
        validateNext(iterator);
        Number result = Number.from(iterator.next());
        while (iterator.hasNext()) {
            Operation operation = Operation.of(iterator.next());
            validateNext(iterator);
            result = operation.calculatedNumber(result, Number.from(iterator.next()));
        }
        return result;
    }

    private void validateNext(Iterator<String> iterator) {
        if (!iterator.hasNext()) {
            throw new IllegalStateException("number string to be calculated is not exists");
        }
    }

    @Override
    public String toString() {
        return "StringCalculator{" +
                "provider=" + provider +
                '}';
    }
}
