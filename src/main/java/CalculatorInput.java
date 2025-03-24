import java.util.List;

public class CalculatorInput {

    private final String input;
    private final List<String> tokens;

    public CalculatorInput(String input) {
        validateInput(input);

        this.input = input;
        this.tokens = List.of(input.split(" "));
    }

    private void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값은 null이거나 빈 문자열일 수 없습니다.");
        }
    }

    public String getInput() {
        return input;
    }

    public List<String> getTokens() {
        return tokens;
    }
}
