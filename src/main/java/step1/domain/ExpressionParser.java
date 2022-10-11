package step1.domain;

public class ExpressionParser {

    private static final String ALLOWABLE_CHARACTERS = "[0-9|\\.|\\+|\\-|\\*|\\/|\\(|\\)]*$";

    private final String[] parsed;

    public ExpressionParser(String expression) {
        verifyInput(expression);
        this.parsed = expression.split(" ");
        validateInput(parsed);
    }

    private void verifyInput(String expression) {
        if (expression.isBlank()) {
            throw new NullPointerException("빈 값을 입력했습니다.");
        }
    }

    private void validateInput(String[] parsedExpression) {
        for (String character : parsedExpression) {
            checkInputCharacters(character);
        }
    }

    private void checkInputCharacters(String character) {
        if (!character.matches(ALLOWABLE_CHARACTERS)) {
            throw new IllegalArgumentException("숫자 또는 사칙연산 기호만 입력 가능합니다.");
        }
    }

    public String[] getParsed() {
        return this.parsed;
    }
}
