package calculator;

import java.util.List;

public class CalculatorController {
    public void start(String input) {
        CalculatorService calculatorService = new CalculatorService();

        List<String> tokens = calculatorService.split(input);

        for (int i = 1; i < tokens.size(); i+=2) {
            calculatorService.calculator(new Operator(tokens.get(1)), new Operand(tokens.get(0)) , new Operand(tokens.get(2)));
        }
        

    }

}
