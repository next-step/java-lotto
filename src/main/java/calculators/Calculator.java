package calculators;

import calculators.vo.Number;

import java.util.List;

public class Calculator {

    private final NumberGenerator numberGenerator;

    public Calculator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Integer calculate(String input) {
        List<Number> numbers = numberGenerator.createNumbers(input);
        return numbers.stream()
                .map(Number::getValue)
                .reduce(0, Integer::sum);
    }
}
