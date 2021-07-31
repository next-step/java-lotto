package calculators;

import calculators.vo.Number;

import java.util.List;

public class Calculator {

    private final NumberGenerator numberGenerator;

    public Calculator() {
        this.numberGenerator = new NumberGenerator();
    }

    public Integer calculate(String input) {
        List<Number> numbers = numberGenerator.getNumbers(input);
        return numbers.stream()
                .map(Number::getValue)
                .reduce(0, Integer::sum);
    }
}
