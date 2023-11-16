package domain.calculator;


import domain.calculator.vo.Number;
import domain.calculator.vo.*;
import util.StringParser;

import java.util.Arrays;

public class Calculator implements CalculatorAble {

    private final Operators operators;
    private final Numbers numbers;
    private String input;

    public Calculator() {
        operators = new Operators();
        numbers = new Numbers();
    }

    public String getInput() {
        return input;
    }

    public Numbers getNumbers() {
        return numbers;
    }

    public int doCalculate(String input) {
        String[] strings = StringParser.parseWhiteSpace(input);
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


        this.input = input;

        int result = 0;

        int i = 0;
        while (i != operators.size()) {
            if (operators.getOperatorList().get(i).getValue() == OperatorEnum.PLUS) {
                result += sum(numbers.getNumbers().get(i).getValue(), numbers.getNumbers().get(i + 1).getValue());
            }

            if (operators.getOperatorList().get(i).getValue() == OperatorEnum.MINUS) {
                result += subtract(numbers.getNumbers().get(i).getValue(), numbers.getNumbers().get(i + 1).getValue());
            }

            if (operators.getOperatorList().get(i).getValue() == OperatorEnum.MULTIPLY) {
                result += multiply(numbers.getNumbers().get(i).getValue(), numbers.getNumbers().get(i + 1).getValue());
            }

            if (operators.getOperatorList().get(i).getValue() == OperatorEnum.DIVIDE) {
                result += divide(numbers.getNumbers().get(i).getValue(), numbers.getNumbers().get(i + 1).getValue());
            }
            i++;
        }

        return result;
    }
}
