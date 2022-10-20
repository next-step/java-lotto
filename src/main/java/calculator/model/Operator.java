package calculator.model;

import calculator.exception.ValidateOperatorException;

import java.util.Objects;

import static calculator.util.NumberUtil.validateEssence;

public enum Operator {

    ADD("+", Operator::add),
    SUB("-", Operator::sub),
    MULTIPLY("*", Operator::multiply),
    DIVIDE("/", Operator::divide);

    private final Calculation calculation;
    private final String operator;

    Operator(String operator, Calculation calculation) {
        this.operator = operator;
        this.calculation = calculation;
    }

    public static Integer calculate(String operator, Integer firstNumber, Integer secondNumber) {
        return getOperator(operator).calculation.calculate(firstNumber,secondNumber);
    }

    private static Operator getOperator(String operator) {
        if (Objects.equals(ADD.operator, operator)) {
            return ADD;
        }
        if (Objects.equals(SUB.operator, operator)) {
            return SUB;
        }
        if (Objects.equals(MULTIPLY.operator, operator)) {
            return MULTIPLY;
        }
        if (Objects.equals(DIVIDE.operator, operator)) {
            return DIVIDE;
        }
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
        return validateEssence(firstNumber, secondNumber);
    }
}
