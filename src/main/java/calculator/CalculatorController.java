package calculator;

import java.util.List;

public class CalculatorController {
    public int start(String input) {
        Parser parser = new Parser();
        Calculator calculator = new Calculator();

        List<String> tokens = parser.split(input);

        Operand result = new Operand(tokens.get(0));

        for (int i = 1; i < tokens.size(); i+=2) {
            Operator operator = new Operator(tokens.get(i));
            Operand right = new Operand(tokens.get(i+1));

            result = calculator.calculator(operator, result, right);
        }

        return result.getValue();
    }

}
