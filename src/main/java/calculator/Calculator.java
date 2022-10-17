package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    private static final String ADD_INDICATOR = "+";
    private static final String MINUS_INDICATOR = "-";

    public int calculate(String input) {
        String[] splitInput = input.split(" ");
        List<Integer> ints = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        Arrays.stream(splitInput).forEach(str -> {
            if(str.equals(ADD_INDICATOR) || str.equals(MINUS_INDICATOR)) {
                operators.add(str);
                return;
            }
            ints.add(Integer.parseInt(str));
        });
        for (int i = 0; i < ints.size(); i++) {
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
        }
        return ints.get(0);
    }

    private int minus(Integer num1, Integer num2) {
        return num1 - num2;
    }

    private int add(int num1, int num2){
        return num1 + num2;
    }
}
