package calculator;

import calculator.operations.Addition;
import calculator.operations.Division;
import calculator.operations.Multiplication;
import calculator.operations.Subtraction;

import java.util.List;

public class Calculator {
    private final Expression expression;
    private int result;

    public Calculator(String expression) {
        this.expression = new Expression(expression);
    }

    public int calculate() {
        List<String> elements = expression.parseToList();
        initializeResult(elements);

        for (String element : elements) {
            checkStatusAndCalculate(element);
            checkOperationStatus(element);
        }
        return result;
    }

    private void initializeResult(List<String> elements) {
        result = Integer.parseInt(elements.remove(0));
    }

    private void checkStatusAndCalculate(String element) {
        addIfStatusIsOn(element);
        subtractIfStatusIsOn(element);
        multiplyIfStatusIsOn(element);
        divideIfStatusIsOn(element);
    }

    private void checkOperationStatus(String element) {
        checkIfAddition(element);
        checkIfSubtraction(element);
        checkIfMultiplication(element);
        checkIfDivision(element);
    }

    private void addIfStatusIsOn(String element) {
        if (Addition.status) {
            result += Integer.parseInt(element);
            Addition.status = false;
        }
    }

    private void subtractIfStatusIsOn(String element) {
        if (Subtraction.status) {
            result -= Integer.parseInt(element);
            Subtraction.status = false;
        }
    }

    private void multiplyIfStatusIsOn(String element) {
        if (Multiplication.status) {
            result *= Integer.parseInt(element);
            Multiplication.status = false;
        }
    }

    private void divideIfStatusIsOn(String element) {
        if (Division.status) {
            validateIfResultIsInt(element);
            Division.status = false;
        }
    }

    private void validateIfResultIsInt(String element) {
        int num = Integer.parseInt(element);
        validateIfElementIsZero(num);
        double floatNum = (double) result / num;
        result /= num;
        if (floatNum != result) {
            Division.status = false;
            throw new ArithmeticException("나누어 떨어지지 않는 값을 입력하셨습니다.");
        }
    }

    private void validateIfElementIsZero(int num) {
        if (num == 0) {
            Division.status = false;
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
    }

    private void checkIfAddition(String element) {
        if (element.equals(Addition.symbol)) {
            Addition.status = true;
        }
    }

    private void checkIfSubtraction(String element) {
        if (element.equals(Subtraction.symbol)) {
            Subtraction.status = true;
        }
    }

    private void checkIfMultiplication(String element) {
        if (element.equals(Multiplication.symbol)) {
            Multiplication.status = true;
        }
    }

    private void checkIfDivision(String element) {
        if (element.equals(Division.symbol)) {
            Division.status = true;
        }
    }
}
