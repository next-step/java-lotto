package calculator.string.service;

import calculator.string.domain.CalculatorSign;
import calculator.string.domain.Calculator;
import calculator.string.domain.Number;

import java.util.ArrayList;
import java.util.List;

public class CalculateService {

    private final String INPUT_SEPARATOR = " ";
    private final int CALCULATOR_AND_NUMBER_SEPARATOR = 2;
    private Calculator calculator = new Calculator();

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

    public List<CalculatorSign> sectionCalculate(String[] values) {
        List<CalculatorSign> calculatorSigns = new ArrayList<>();
        for(int i=1; i < values.length; i+= CALCULATOR_AND_NUMBER_SEPARATOR) {
            isBlank(values[i]);
            calculatorSigns.add(CalculatorSign.fromString(values[i]));
        }
        return calculatorSigns;
    }

    private void isBlank(String value) {
        if(value.isBlank()) {
            throw new IllegalArgumentException("입력값이 Null 이거나 빈 공백 문자입니다.");
        }
    }

    public int iterNumbersAndCalculatorSigns(List<Number> numbers, List<CalculatorSign> calculatorSigns) {
        int number = numbers.get(0).getNumber();
        for(int i = 1; i < numbers.size(); i++ ) {
            number = calculate(number, numbers.get(i).getNumber(), calculatorSigns.get(i - 1));
        }
        return number;
    }

    private int calculate(int resultNumber, int nextNumber, CalculatorSign calculatorSign) {

        switch (calculatorSign) {
            case MULTIPLY:
                resultNumber = calculator.multiply(resultNumber, nextNumber);
                break;
            case ADD:
                resultNumber = calculator.add(resultNumber, nextNumber);
                break;
            case SUB:
                resultNumber = calculator.substract(resultNumber, nextNumber);
                break;
            case DIVIDE:
                resultNumber = calculator.divide(resultNumber, nextNumber);
                break;
            default:
                throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }

        return resultNumber;
    }
}
