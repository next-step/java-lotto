package domain.calculator;


import domain.calculator.vo.Number;
import domain.calculator.vo.*;
import util.StringParser;

import java.util.Arrays;

public class Calculator implements CalculatorAble {

    private final Operators operators;
    private final Numbers numbers;

    public Calculator() {
        operators = new Operators();
        numbers = new Numbers();
    }

    public Numbers getNumbers() {
        return numbers;
    }

    public Operators getOperators() {
        return operators;
    }

    public int getResult(String input) {
        String[] strings = StringParser.parseWhiteSpace(input);
        setNumbersAndOperators(strings);
        return doCalculate();
    }

    private void setNumbersAndOperators(String[] strings) {
        Arrays.stream(strings).forEach(o -> {
            try {
                int integer = Integer.parseInt(o);
                Number number = new Number(integer);
                numbers.add(number);
            } catch (NumberFormatException e) {
                Operator operator = new Operator(OperatorEnum.of(o));
                operators.add(operator);

            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        });
    }

    private int doCalculate() {
        int result = 0;
        int i = 0;
        while (i != operators.size()) {
            int leftNumber = i == 0 ? numbers.getNumberList().get(i).getValue() : result;
            int rightNumber = numbers.getNumberList().get(i + 1).getValue();
            result = calculate(leftNumber, rightNumber, operators.getOperatorList().get(i));
            i++;
        }

        return result;
    }

    private int calculate(int leftNumber, int rightNumber, Operator operator) {
        if (operator.getValue() == OperatorEnum.PLUS) {
            return sum(leftNumber, rightNumber);
        }

        if (operator.getValue() == OperatorEnum.MINUS) {
            return subtract(leftNumber, rightNumber);
        }

        if (operator.getValue() == OperatorEnum.MULTIPLY) {
            return multiply(leftNumber, rightNumber);
        }

        if (operator.getValue() == OperatorEnum.DIVIDE) {
            return divide(leftNumber, rightNumber);
        }
        
        throw new IllegalArgumentException("잘못된 입력입니다.");
    }
}
