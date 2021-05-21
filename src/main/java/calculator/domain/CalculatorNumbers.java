package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CalculatorNumbers {

    private List<CalculatorNumber> calculatorNumberList;

    public CalculatorNumbers(List<CalculatorNumber> calculatorNumberList) {
        this.calculatorNumberList = calculatorNumberList;
    }

    public int sum() {
        return calculatorNumberList.stream()
                .mapToInt(CalculatorNumber::getValue)
                .sum();
    }

    public static CalculatorNumbers from(String[] numbers) {
        List<CalculatorNumber> calculatorNumberList = new ArrayList<>();

        for (String number : numbers) {
            calculatorNumberList.add(new CalculatorNumber(number));
        }

        return new CalculatorNumbers(calculatorNumberList);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculatorNumbers that = (CalculatorNumbers) o;
        return Objects.equals(calculatorNumberList, that.calculatorNumberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calculatorNumberList);
    }
}
