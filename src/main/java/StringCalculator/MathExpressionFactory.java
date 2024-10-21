package StringCalculator;

import java.util.ArrayList;
import java.util.List;

public class MathExpressionFactory {

    public static MathExpression seperateAndCreateMathExpression(String input) {
        String[] inputList = input.split(" ");
        List<Integer> numbers = new ArrayList<>();
        List<String> operations = new ArrayList<>();

        for (int i = 0; i < inputList.length; i++) {
            if (i % 2 == 1) {
                operations.add(inputList[i]);
                continue;
            }
            numbers.add(Integer.parseInt(inputList[i]));
        }

        return new MathExpression(numbers, operations);
    }


}
