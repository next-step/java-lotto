package lotto.step1.calculator;

import lotto.step1.input.UserInput;

import java.util.List;

public class StringCalculator {
    public static String calculate(final UserInput userInput) {
        int calculateNumberIndex = 0;
        final List<String> nums = userInput.getNums();
        String answer = nums.get(calculateNumberIndex);

        for (String operatorSymbol : userInput.getOperators()) {
            String nextNumber = nums.get(++calculateNumberIndex);
            
            answer = Operator.findBySymbol(operatorSymbol).calculate(answer, nextNumber);
        }

        return answer;
    }
}
