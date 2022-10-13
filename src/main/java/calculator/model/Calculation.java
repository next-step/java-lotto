package calculator.model;

import calculator.exception.ValidateOperatorException;

import java.util.Objects;

import static calculator.util.NumberUtil.isEssence;

public enum Calculation {

    ADD("+"),
    SUB("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String operator;

    Calculation(String operator) {
        this.operator = operator;
    }

    public static Integer valueOf(String operator, Integer firstNumber, Integer secondNumber) {

        if (Objects.equals(operator, ADD.operator)) return add(firstNumber, secondNumber);
        if (Objects.equals(operator, SUB.operator)) return sub(firstNumber, secondNumber);
        if (Objects.equals(operator, MULTIPLY.operator)) return multiply(firstNumber, secondNumber);
        if (Objects.equals(operator, DIVIDE.operator)) return divide(firstNumber, secondNumber);

        throw new ValidateOperatorException();
    }


    private static Integer add(Integer firstNumber, Integer secondNumber) {
        return firstNumber + secondNumber;
    }

    private static Integer sub(Integer firstNumber, Integer secondNumber) {
        return firstNumber - secondNumber;
    }

    private static Integer multiply(Integer firstNumber, Integer secondNumber) {
        return firstNumber * secondNumber;
    }

    private static Integer divide(Integer firstNumber, Integer secondNumber) {
        return isEssence(firstNumber, secondNumber);
    }
}
