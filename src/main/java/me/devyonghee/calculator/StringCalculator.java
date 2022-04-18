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

    Number calculate() {
        return calculator().calculate();
    }

    private Calculator calculator() {
        Iterator<String> iterator = provider.strings().iterator();
        Number fistNumber = Number.from(iterator.next());
        Calculator calculator = () -> fistNumber;
        while (iterator.hasNext()) {
            calculator = CalculatorFactory.calculator(Operation.of(iterator.next()), calculator, Number.from(iterator.next()));
        }
        return calculator;
    }
}
