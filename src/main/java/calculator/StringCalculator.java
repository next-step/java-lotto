package calculator;

import java.util.List;

public class StringCalculator {

    public Number calculate(List<String> strings) {
        Number result = Number.IntToNumberFactory(0);
        ArithmeticOperation arithmeticOperation = new Plus();
        for (int i = 0; i < strings.size(); i++) {
            if (i % 2 == 0) {
                result = arithmeticOperation.calculate(result, Number.stringToNumberFactory(strings.get(i)));
            } else {
                arithmeticOperation = ArithmeticOperation.sign(strings.get(i));
            }
        }
        return result;
    }
}
