package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private List<Number> numbers = new ArrayList<>();
    private List<Arithmetic> arithmetics = new ArrayList<>();

    public StringCalculator(List<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            fillNumbersAndArithmetics(strings, i);
        }
    }

    private void fillNumbersAndArithmetics(List<String> strings, int i) {
        if (i % 2 == 0) {
            numbers.add(new Number(strings.get(i)));
            return;
        }
        arithmetics.add(Arithmetic.findSign(strings.get(i)));
    }

    public Number calculate() {
        Number result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            result = arithmetics.get(i - 1).calculate(result, numbers.get(i));
        }
        return result;
    }

}
