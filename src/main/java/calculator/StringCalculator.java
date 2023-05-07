package calculator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

    private static final String DELIMITER = " ";

    public int calculate(String input){
        validateInput(input);
        List<String> expression = parse(input);

        int seed = getOperand(expression.get(0));

        for(int i = 1; i < expression.size(); i+=2){
            Operator operator = Operator.find(expression.get(i));
            int operand = getOperand(expression.get(i+1));
            seed = operator.calculate(seed, operand);
        }

        return seed;
    }

    // ---------------------------------------------------------------------------------------------------------------------
    // private method
    // ---------------------------------------------------------------------------------------------------------------------

    private void validateInput(String input) {
        if(input == null || input.isBlank()){
            throw new IllegalArgumentException("input은 null이거나 blank일 수 없습니다");
        }
    }

    private List<String> parse(String input){
        List<String> expression = Stream.of(input.split(DELIMITER)).collect(Collectors.toList());

        if(expression.size()%2 == 0){
            throw new IllegalArgumentException("연산자와 피연산자의 개수가 맞지 않습니다 " + input);
        }

        return expression;
    }

    private int getOperand(String value){
        try{
            return Integer.parseInt(value);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("피연산자 자리에는 숫자가 나와야 합니다");
        }
    }
}
