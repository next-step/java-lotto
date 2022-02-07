package lotto.domain;

public class Budget {

    private final static String NOT_A_NUMBER_EXCEPTION_MESSAGE = "숫자만 입력 가능합니다.";

    private final int value;

    public Budget(final String budget) {
        try {
            this.value = Integer.parseInt(budget);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    String.format("%s (Input: %s)", NOT_A_NUMBER_EXCEPTION_MESSAGE, budget));
        }
    }

    public int getValue() {
        return value;
    }
}
