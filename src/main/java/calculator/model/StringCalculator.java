package calculator.model;

import calculator.exception.ValidateInputException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static calculator.util.NumberUtil.*;
import static calculator.util.OperatorUtil.*;

public class StringCalculator {

    private static final String ADD = "+";
    private static final String SUB = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    public Integer calculate(String input) {
        List<String> inputList = makeInputList(input);

        Integer firstNumber = isNumber(inputList.get(0));

        for (int i = 1; i < inputList.size(); i += 2) {
            String operator = inputList.get(i);
            Integer secondNumber = isNumber(inputList.get(i + 1));
            firstNumber = getCalculate(operator, firstNumber, secondNumber);
        }

        return firstNumber;
    }

    private Integer getCalculate(String operator, Integer firstNumber, Integer secondNumber) {
        String validateOperator = isOperator(operator);

        if (Objects.equals(validateOperator, ADD)) {
            return add(firstNumber, secondNumber);
        }

        if (Objects.equals(validateOperator, SUB)) {
            return sub(firstNumber, secondNumber);
        }

        if (Objects.equals(validateOperator, MULTIPLY)) {
            return multiply(firstNumber, secondNumber);
        }

        if (Objects.equals(validateOperator, DIVIDE)) {
            return divide(firstNumber, secondNumber);
        }

        return firstNumber;
    }

    public List<String> makeInputList(String input) {
        String validateInput = validateInput(input);

        return Arrays.stream(validateInput.split(" "))
                .collect(Collectors.toList());
    }

    public String validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new ValidateInputException();
        }
        return input;
    }

    public Integer add(Integer firstNumber, Integer secondNumber) {
        return firstNumber + secondNumber;
    }

    public Integer sub(Integer firstNumber, Integer secondNumber) {
        return firstNumber - secondNumber;
    }

    public Integer multiply(Integer firstNumber, Integer secondNumber) {
        return firstNumber * secondNumber;
    }

    public Integer divide(Integer firstNumber, Integer secondNumber) {
        return isEssence(firstNumber, secondNumber);
    }
}
