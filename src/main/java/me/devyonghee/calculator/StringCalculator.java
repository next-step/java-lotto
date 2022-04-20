package me.devyonghee.calculator;

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
        return calculator().calculatedNumber();
    }

    private Calculator calculator() {
        Iterator<String> iterator = provider.strings().iterator();
        validateNext(iterator);

        Number fistNumber = Number.from(iterator.next());
        Calculator calculator = () -> fistNumber;
        while (iterator.hasNext()) {
            Operation operation = Operation.of(iterator.next());
            validateNext(iterator);
            calculator = operation.calculator(calculator, Number.from(iterator.next()));
        }
        return calculator;
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
