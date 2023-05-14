package lotto.domain;

public class Number implements Comparable<Number> {
    public static final String ERROR_MESSAGE_INPUT_NOT_INTEGER = "정수가 아닌 값은 입력할 수 없습니다.";
    public static final String ERROR_MESSAGE_INPUT_NOT_VAILD_NUMBER = "1~45 사이의 값을 입력해주세요.";
    private static final int LOTTO_NUMBER_LOWER_BOUND = 1;
    private static final int LOTTO_NUMBER_UPPER_BOUND = 45;

    private final int number;

    Number(int number) {
        validateNumber(number);
        this.number = number;
    }

    Number(String number) {
        validateNumber(number);
        validateNumber(Integer.parseInt(number));
        this.number = Integer.parseInt(number);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Number o) {
        return Integer.compare(this.number, o.number);
    }


    private static void validateNumber(String number) {
        if (number.isBlank() || !number.chars().allMatch(Character::isDigit)) {
            throw new RuntimeException(ERROR_MESSAGE_INPUT_NOT_INTEGER);
        }
    }

    private static void validateNumber(int number) {
        if (number < LOTTO_NUMBER_LOWER_BOUND || number > LOTTO_NUMBER_UPPER_BOUND) {
            throw new RuntimeException(ERROR_MESSAGE_INPUT_NOT_VAILD_NUMBER);
        }
    }
}
