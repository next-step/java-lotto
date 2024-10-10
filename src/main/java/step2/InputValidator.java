package step2;

public class InputValidator {

    public void validate(String input) {
        isEmpty(input);
        isNotNumber(input);
        isNegativePrice(input);
    }

    private void isEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("구매 금액을 입력해 주세요.");
        }
    }

    private void isNotNumber(String input) {
        try {
            int price = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입 금액을 확인해 주세요.");
        }
    }

    private void isNegativePrice(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException("구매 금액은 음수일 수 없습니다.");
        }
    }

}
