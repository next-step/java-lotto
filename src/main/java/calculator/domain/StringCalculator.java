package calculator.domain;

import calculator.util.Tokenizer;
import java.util.Objects;

public class StringCalculator {

    private final String text;

    public StringCalculator(String text) {
        this.text = text;
    }

    public int add() {
        if (isEmptyOrNull(text)) {
            return 0;
        }

        int result = 0;
        for(Integer number : Tokenizer.tokenize(text)) {
            validateNegative(number);
            result += number;
        }

        return result;
    }

    private boolean isEmptyOrNull(String text) {
        return Objects.isNull(text) || text.isEmpty();
    }

    private void validateNegative(Integer number) {
        if(number < 0) {
            throw new IllegalArgumentException("[ERROR] 음수는 입력할 수 없습니다.");
        }
    }

}
