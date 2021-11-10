package lotto.vo;

public class Money {

    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "입력 값이 숫자가 아닙니다.";
    private static final String NUMBER_RANGE_EXCEPTION_MESSAGE = "입력 값은 1000원 보다 적을 수 없습니다.";
    private static final String EMPTY_EXCEPTION_MESSAGE = "입력 값은 빈 값 일 수 없습니다.";

    private final int value;

    private Money(int value) {
        this.value = value;
    }

    public static Money create(String input) {
        if(input == null || input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_EXCEPTION_MESSAGE);
        }

        if(input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION_MESSAGE);
        }

        int value = Integer.parseInt(input);
        if(value < 1000) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION_MESSAGE);
        }

        return new Money(value);
    }
}
