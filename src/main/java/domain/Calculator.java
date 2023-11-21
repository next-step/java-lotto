package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator implements Addition, Subtraction, Multiplication, Division {
    public String input;
    public List<String> inputList;

    public Calculator() {

    }

    public Calculator(String input) {
        this.input = input;
    }

    public void init() {
        inputList = inputSeparate(input);

        for (int i = 0; i < input.length() / 4; i++) {
            calc();
        }
    }

    public void calc() {

        int firstNumber = Integer.parseInt(inputList.get(0));
        String operator = inputList.get(1);
        int secondNumber = Integer.parseInt(inputList.get(2));
        int result = getOperationResult(operator, firstNumber, secondNumber);

        inputList.subList(0, 3).clear();
        inputList.add(0, String.valueOf(result));
    }

    public int testMethod(String a, int b, int c) {
        return getOperationResult(a, b, c);
    }

    private int getOperationResult(String operator, int firstNumber, int secondNumber) {
        int result;
        switch (operator) {
            case "+":
                result = addition(firstNumber, secondNumber);
                break;
            case "-":
                result = subtraction(firstNumber, secondNumber);
                break;
            case "*":
                result = multiplication(firstNumber, secondNumber);
                break;
            case "/":
                result = division(firstNumber, secondNumber);
                break;
            default:
                throw new IllegalArgumentException("+, -, *, / 외의 특수문자 불가. 입력:" + operator);
        }
        return result;
    }


    private List<String> inputSeparate(String input) {
        return Arrays.stream(input.split(" "))
                .map(String::new)
                .collect(Collectors.toList());
    }

    @Override
    public int addition(int a, int b) {
        return a + b;
    }

    @Override
    public int subtraction(int a, int b) {
        return a - b;
    }

    @Override
    public int multiplication(int a, int b) {
        return a * b;
    }

    @Override
    public int division(int a, int b) {
        return a / b;
    }
}
