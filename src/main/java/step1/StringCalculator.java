package step1;

import step1.CalculateStratety.CalculateStrategy;

public class StringCalculator {

    Strategies strategies = new Strategies();
    int result = 0;

    public int calculate(Formula formula) {

        result = formula.pollNumber();
        while (formula.peek() != null){
            CalculateStrategy strategy = strategies.getStrategy(formula.poll());
            result = strategy.go(result, formula.pollNumber());
        }

        return result;
    }


}
