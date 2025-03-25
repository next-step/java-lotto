import java.util.ArrayList;
import java.util.List;

public class CalculatorInput {

    private final List<String> tokens;

    public CalculatorInput(String input) {
        validateInput(input);
        this.tokens = new ArrayList<>(List.of(input.split(" ")));
        validateTokens();
    }

    private void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값은 null이거나 빈 문자열일 수 없습니다.");
        }
    }

    private void validateTokens() {
        for (int i = 0; i < tokens.size(); i++) {
            if (i % 2 == 0) {
                validateNumber(tokens.get(i));
            } else {
                validateOperator(tokens.get(i));
            }
        }
    }

    private void validateNumber(String token) {
        try {
            Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다: " + token);
        }
    }

    private void validateOperator(String operator) {
        if (!ArithmeticOperator.isValidOperator(operator)) {
            throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + operator);
        }
    }

    public List<String> getTokens() {
        return tokens;
    }
}
