package calculator.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private final Pattern NUMBER = Pattern.compile("[0-9]+");
    private final Pattern OPERATOR = Pattern.compile("[+\\-*/]");
    private int result;

    public static String splitString(String input){
        return Arrays.toString(input.split(" "));
    }

    public List<String> splitOperands(String expression) {
        Matcher matcher = NUMBER.matcher(expression);
        List<String> operands = new ArrayList<>();

        while (matcher.find()) {
            operands.add((matcher.group()));
        }

        return operands;
    }

    public List<String> splitOperators(String expression) {
        Matcher matcher = OPERATOR.matcher(expression);
        List<String> operators = new ArrayList<>();

        while (matcher.find()) {
            operators.add(matcher.group());
        }

        return operators;
    }

    public int operationFormula(List<String> operands, List<String> operators) {
        Validator.checkCount(operands,operators);

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
        return Validator.division(this.result, targetNum);

    }

    public int calculateExpression(String inputExpression) {
        List<String> operands = splitOperands(inputExpression);
        List<String> operators = splitOperators(Validator.operatorCheck(inputExpression));

        return operationFormula(operands,operators);
    }
}
