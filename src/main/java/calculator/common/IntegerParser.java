package calculator.common;

public class IntegerParser {

    public int parse(String element) {
        int value;
        value = parseWithValidation(element);
        validateValueIsPositive(value);
        return value;
    }

    private int parseWithValidation(String element) {
        int value;
        try {
            value = Integer.parseInt(element);
        } catch (NumberFormatException e) {
            throw new RuntimeException("잘못된 인자를 전달하였습니다.");
        }
        return value;
    }

    private void validateValueIsPositive(int value) {
        if (value < 0) {
            throw new RuntimeException("음수는 사용할 수 없습니다.");
        }
    }
}
