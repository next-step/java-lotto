package caculator.domain;

import java.util.List;

public class Processor {
    private static final String INTEGER_REGEX = "-?\\d+";
    private Calculator calculator;
    public Processor(Calculator calculator) {
        this.calculator = calculator;
    }

    public int process(List<String> inputs){


        int result = 0;
        for (String input : inputs) {
            result = runCalculate(result, input);
        }

        return result;
    }

    private int runCalculate(int result, String input) {
        if(IntOperator.isOperator(input)){
            calculator.saveOperation(input);
        }
        if(input.matches(INTEGER_REGEX)){
            result = calculator.calculate(Integer.parseInt(input));
            calculator.resetOperation();
        }
        return result;
    }

}




