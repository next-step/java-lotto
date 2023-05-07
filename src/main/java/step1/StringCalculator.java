package step1;

import step1.CalculateStratety.CalculateStrategy;

public class StringCalculator {

    public static final String SIGN_REGEX = "[+*-/]";
    Strategies strategies = new Strategies();
    int result = 0;

    public int calculate(Formula formula) {

        result = formula.pollNumber();
        while (formula.peek() != null){
            String sign = formula.poll();
            signValidationCheck(sign);
            CalculateStrategy strategy = strategies.getStrategy(sign);
            result = strategy.go(result, formula.pollNumber());
        }

        return result;
    }

    private void signValidationCheck(String sign) {
        if(!sign.matches(SIGN_REGEX)){
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
    }

}
