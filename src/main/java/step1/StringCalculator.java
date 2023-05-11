package step1;

import step1.CalculateStratety.CalculateStrategy;

public class StringCalculator {



    Strategies strategies = new Strategies();
    int result = 0;

    public int calculate(Formula formula) {

        result = formula.pollNumber();
        while (formula.peek() != null){
            String sign = formula.poll();
            strategies.signValidationCheck(sign);
            CalculateStrategy strategy = strategies.getStrategy(sign);
            result = strategy.go(result, formula.pollNumber());
        }

        return result;
    }


}
