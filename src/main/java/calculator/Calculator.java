package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;

public class Calculator {

    private static final String ADD_INDICATOR = "+";
    private static final String MINUS_INDICATOR = "-";
    private static final String MULTIPLY_INDICATOR = "*";
    private static final String DIVIDE_INDICATOR = "/";

    public int calculate(String input) {
        if(input == null || input.equals("")) throw new IllegalArgumentException("input cannot be empty");
        String[] splitInput = input.split(" ");
        List<Integer> ints = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        Arrays.stream(splitInput).forEach(str -> {
            if(str.matches("[0-9]+")){
                ints.add(Integer.parseInt(str));
                return;
            }
            operators.add(str);
        });

        operators.forEach(operator -> {
            if(!OperatorType.getAllIndicators().contains(operator)) throw new IllegalArgumentException("wrong operator type");
        });

        for (int i = 0; i < operators.size(); i++) {
            String operator = operators.get(i);
            if(operator.equals(ADD_INDICATOR)){
                int result = add(ints.get(0), ints.get(1));
                ints.set(0, result);
                ints.remove(1);
            }
            if(operator.equals(MINUS_INDICATOR)){
                int result = minus(ints.get(0), ints.get(1));
                ints.set(0, result);
                ints.remove(1);
            }
            if(operator.equals(MULTIPLY_INDICATOR)){
                int result = multiply(ints.get(0), ints.get(1));
                ints.set(0, result);
                ints.remove(1);
            }
            if(operator.equals(DIVIDE_INDICATOR)){
                int result = divide(ints.get(0), ints.get(1));
                ints.set(0, result);
                ints.remove(1);
            }
        }
        return ints.get(0);
    }

    private int minus(Integer num1, Integer num2) {
        return num1 - num2;
    }

    private int add(int num1, int num2){
        return num1 + num2;
    }

    private int multiply(int num1, int num2){
        return num1 * num2;
    }

    private int divide(int num1, int num2){
        return num1 / num2;
    }
}
