package calculator;

public class Calculator {
        String[] split = input.split(" ");
        int result = Integer.parseInt(split[0]);

        for (int i = 1; i < split.length; i++) {
            result = Operator.findOperator(split[i])
                    .calculate(result, Integer.parseInt(split[++i].trim()));
        }
        return result;
    }
}
