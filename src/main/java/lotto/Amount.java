package lotto;

public class Amount {
    private final int value;

    public Amount(String input) {
        if (hasNoInput(input)) {
            throw new IllegalArgumentException("구입금액으로 빈 값이 입력되었습니다.");
        }

        this.value = toAmountValue(input);
    }

    private int toAmountValue(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력할 수 있습니다.");
        }

        if (number < 1000) {
            throw new IllegalArgumentException("1000원 이상의 금액을 입력하세요.");
        }

        return number;
    }

    private boolean hasNoInput(String input) {
        return input == null || input.isBlank();
    }

    public int value() {
        return value;
    }
}
