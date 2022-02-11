package calculator.domain;

import java.util.List;

public class StringCalculator {

    private final int result;

    public StringCalculator(NumberTokens numberTokens) {
        validateNegative(numberTokens.getNumbers());
        this.result = createResult(numberTokens.getNumbers());
    }

    public int createResult(List<Integer> tokenized)  {
        if(tokenized.isEmpty()) {
            return 0;
        }
        return tokenized.stream().mapToInt(number -> number).sum();
    }

    private void validateNegative(List<Integer> tokenized) {
        if(tokenized.stream().anyMatch(number -> number < 0)) {
            throw new IllegalArgumentException("[ERROR] 음수는 입력할 수 없습니다.");
        }
        tokenized.clear();
        System.out.println(tokenized);
    }

    public int getResult() {
        return result;
    }
}
