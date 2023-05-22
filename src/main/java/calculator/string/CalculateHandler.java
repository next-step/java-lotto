package calculator.string;

import calculator.string.domain.CalculatorSymbol;
import calculator.string.domain.Number;

import java.util.ArrayList;
import java.util.List;

public class CalculateHandler {

    private final String INPUT_SEPARATOR = " ";
    private final int CALCULATOR_AND_NUMBER_SEPARATOR = 2;

    public String[] split(String inputValue) {
        return inputValue.split(INPUT_SEPARATOR);
    }
    public List<Number> sectionNumber(String[] values) {
        List<Number> numbers = new ArrayList<>();
        for(int i=0; i < values.length; i+= CALCULATOR_AND_NUMBER_SEPARATOR) {
            isBlank(values[i]);
            numbers.add(new Number(values[i]));
        }
        return numbers;
    }

    public List<CalculatorSymbol> sectionCalculate(String[] values) {
        List<CalculatorSymbol> calculatorSymbols = new ArrayList<>();
        for(int i=1; i < values.length; i+= CALCULATOR_AND_NUMBER_SEPARATOR) {
            isBlank(values[i]);
            calculatorSymbols.add(CalculatorSymbol.getSymbol(values[i]));
        }
        return calculatorSymbols;
    }

    private void isBlank(String value) {
        if(value.isBlank()) {
            throw new IllegalArgumentException("입력값이 Null 이거나 빈 공백 문자입니다.");
        }
    }

    public int calculate(List<Number> numbers, List<CalculatorSymbol> calculatorSymbols) {
        int number = numbers.get(0).getNumber();
        for(int i = 1; i < numbers.size(); i++ ) {
            number = calculatorSymbols.get(i - 1).calculate(number, numbers.get(i).getNumber());
        }
        return number;
    }
}
