package calculator.model;

import org.assertj.core.util.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private final Pattern NUMBER = Pattern.compile("[0-9]+");
    private final Pattern OPERATOR = Pattern.compile("[+\\-*/]");
    private int result;

    public List<String> splitOperands(String expression) {
        Matcher matcher = NUMBER.matcher(expression);
        List<String> operands = new ArrayList<>();

        while (matcher.find()) {
            //operands.add(new Number(matcher.group()));
            operands.add((matcher.group()));

        }

        return operands;
    }

    public List<String> splitOperators(String expression) {
        Matcher matcher = OPERATOR.matcher(expression);
        List<String> operators = new ArrayList<>();

        while (matcher.find()) {
            //operators.add(Operator.of(matcher.group()));
            operators.add(matcher.group());
        }

        return operators;
    }

    public int operationFormula333(List<String> targetList) {
        int count = targetList.size();

        this.result = Integer.parseInt(targetList.get(0));

        for (int i = 1 ; i < count ; i = i+2) {
            this.result = calculate(targetList.get(i), targetList.get(i + 1));
        }

        return this.result;
    }

    public int operationFormula(List<String> operands, List<String> operators) {

        this.result = Integer.parseInt(operands.get(0));

        for (int i = 0 ; i < operators.size() ; i++) {
            this.result = calculate(operators.get(i),operands.get(i+1));
        }

        return this.result;
    }

    public int calculate(String operator , String operand) {
        int targetNum = Integer.parseInt(operand);

        if(operator.equals("+")) {
            return this.result + targetNum;
        }
        if(operator.equals("-")) {
            return this.result - targetNum;
        }
        if(operator.equals("*")) {
            return this.result * targetNum;
        }
        return division(targetNum);

    }

    private int division(int input) {
        if(input == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }

        if(result % input != 0) {
            throw new IllegalArgumentException("정수로 나누어지지 않습니다.");
        }
        return this.result / input;
    }

}
