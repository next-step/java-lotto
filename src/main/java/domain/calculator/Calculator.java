package domain.calculator;


import domain.calculator.vo.Number;
import domain.calculator.vo.Numbers;
import domain.calculator.vo.OperatorEnum;
import domain.calculator.vo.Operators;
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
            if (validateNumber(o)) {
                numbers.add(new Number(Integer.parseInt(o)));
            }
            if (validateOperator(o)) {
                operators.add(OperatorEnum.from(o));
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

    private boolean validateNumber(String number) {
        return number.matches("^\\d*$");
    }

    private boolean validateOperator(String operator) {
        return operator.matches("^[+-/*]$");
    }

    private int calculate(int leftNumber, int rightNumber, OperatorEnum operator) {
        return operator.calculate(leftNumber, rightNumber);
    }
}
