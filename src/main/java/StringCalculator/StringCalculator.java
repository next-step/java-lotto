package StringCalculator;

import java.util.List;

public class StringCalculator {
    private final static String PLUS = "+";
    private final static String MINUS = "-";
    private final static String MULTIPLY = "*";
    private final static String DIVIDE = "/";

    public static int calculate(String input) {
        int sum = 0;
        List<String> inputs = List.of(input.split(" "));
        for(int i=0; i < inputs.size(); i++){
            System.out.println(inputs.get(i));
            if(inputs.get(i).matches("^[0-9]+$")){
                if(i==0){
                    sum = Integer.valueOf(inputs.get(0));
                }else {
                    sum = operating(sum, inputs.get(i - 1), Integer.valueOf(inputs.get(i)));
                }
            }
        }

        return sum;
    }

    private static int operating(int sum, String operation, int value){
        if(PLUS.equals(operation)){
            return sum + value;
        }

        if(MINUS.equals(operation)){
            return sum - value;
        }

        if(MULTIPLY.equals(operation)){
            return sum * value;
        }

        if(DIVIDE.equals(operation)){
            return sum / value;
        }

        throw new IllegalArgumentException();
    }
}
