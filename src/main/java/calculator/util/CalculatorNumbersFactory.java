package calculator.util;

import calculator.domain.CalculatorNumber;
import calculator.domain.CalculatorNumbers;

import java.util.ArrayList;
import java.util.List;

public class CalculatorNumbersFactory {

    private CalculatorNumbersFactory() {

    }

    public static CalculatorNumbers from(String[] numbers) {
        List<CalculatorNumber> calculatorNumberList = new ArrayList<>();

        for (String number : numbers) {
            calculatorNumberList.add(new CalculatorNumber(number));
        }

        return new CalculatorNumbers(calculatorNumberList);
    }
}
