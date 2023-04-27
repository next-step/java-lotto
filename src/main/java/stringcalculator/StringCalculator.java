package stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private final String NUMBER_REGEX = "^[0-9]*$";
    private final String OPERATION_REGEX = "^[+\\-*/]+$";
    private final List<Double> numbers = new ArrayList<>();
    private final List<String> operators = new ArrayList<>();
    private double result;

    public StringCalculator(String input) {
        validateBlank(input);
        String[] strings = splitInput(input);
        result = Double.parseDouble(strings[0]);
        for (int i = 0; i < strings.length; i++) {
            separateInput(strings, i);
        }
    }

    private void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
    }

    private String[] splitInput(String input) {
        return input.split(" ");
    }

    private void separateInput(String[] strings, int i) {
        if (i % 2 == 1) {
            validateOperation(strings[i]);
            operators.add(strings[i]);
            return;
        }
        validateNumber(strings[i]);
        numbers.add(Double.valueOf(strings[i]));
    }

    private void validateOperation(String operation) {
        if (!operation.matches(OPERATION_REGEX)){
            throw new IllegalArgumentException("사칙연산 기호 외의 값을 입력하였습니다.");
        }
    }
    private void validateNumber(String number) {
        if (!number.matches(NUMBER_REGEX)){
            throw new IllegalArgumentException("숫자 외의 값을 입력하였습니다.");
        }
    }

    public String getOperator(int index){
        return operators.get(index);
    }

    public Double getNumber(int index){
        return numbers.get(index);
    }

    public Double calculate() {
        for (int i = 0; i < operators.size(); i++) {
            calculateEach(operators.get(i),numbers.get(i+1));
        }
        return result;
    }

    private void calculateEach(String symbol, Double number) {
        Operation operation = Operation.find(symbol);
        if(operation == null){
            throw new IllegalArgumentException();
        }
        result = operation.calculate(result,number);
    }

    public Double getResult() {
        return result;
    }
}
