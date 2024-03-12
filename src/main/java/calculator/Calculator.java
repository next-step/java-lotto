package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {

    private static final String MATH_EXPRESSION_PATTERN = "^[+\\-]?\\d( ?[*\\-+/] ?\\d)*$";
    protected Calculator(){}

    public static Calculator of(){
        return new Calculator();
    }

    public boolean isValidMathExpression(String rawExpression){
        if(rawExpression == null || !rawExpression.matches(MATH_EXPRESSION_PATTERN)){
            throw new IllegalArgumentException("please input valid value");
        }
        return true;
    }

    public List<String> splitByBlank(String lowExpression){
        return Arrays.stream(lowExpression.split(" "))
                .map(String::trim).collect(Collectors.toList());
    }

    public int runCalculator(List<String> expression){
        int result = Integer.parseInt(expression.get(0));

        for (int i = 1; i < expression.size(); i += 2) {
            String operator = expression.get(i);
            int number = Integer.parseInt(expression.get(i + 1));
            result = calculate(result, operator, number);
        }
        return result;
    }

    public int calculate(int num1, String operator, int num2){
        if (operator.equals("+")) {
            return add(num1, num2);
        }
        if (operator.equals("-")) {
            return minus(num1, num2);
        }
        if (operator.equals("*")) {
            return multiply(num1, num2);
        }
        if (operator.equals("/")) {
            return divide(num1, num2);
        }
        throw new IllegalArgumentException("잘못된 연산자입니다.");
    }

    private int add(int num1, int num2) {
        return num1+num2;
    }

    private int minus(int num1, int num2) {
        return num1-num2;
    }

    private int multiply(int num1, int num2) {
        return num1*num2;
    }

    private int divide(int num1, int num2) {
        if( num2 == 0 ) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return num1/num2;
    }
}
