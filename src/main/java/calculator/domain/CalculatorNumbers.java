package calculator.domain;

import java.util.List;

public class CalculatorNumbers {
    private List<CalculatorNumber> calculatorNumbers;

    public CalculatorNumbers(List<CalculatorNumber> calculatorNumbers) {
        this.calculatorNumbers = calculatorNumbers;
    }

    public int sum() {
        return calculatorNumbers.stream()
                .mapToInt(CalculatorNumber::getNumber)
                .sum();
    }
}
