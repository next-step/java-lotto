package calculator.domain;

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
