package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Number implements Comparable<Number> {
    public static final String ERROR_MESSAGE_INPUT_NOT_INTEGER = "정수가 아닌 값은 입력할 수 없습니다.";
    public static final String ERROR_MESSAGE_INPUT_NOT_VAILD_NUMBER = "1~45 사이의 값을 입력해주세요.";
    public static final int LOTTO_NUMBER_LOWER_BOUND = 1;
    public static final int LOTTO_NUMBER_UPPER_BOUND = 45;

    private final int number;
    private static final Map<Integer,Number> numbers = new HashMap<>();

    static Number from(String lottoNumber) {
        validateNumber(lottoNumber);
        return from(Integer.parseInt(lottoNumber));
    }

    static Number from(int lottoNumber) {
        Number cacheNumber = numbers.get(lottoNumber);
        if (cacheNumber == null) {
            Number number = new Number(lottoNumber);
            numbers.put(lottoNumber, number);
            return number;
        }
        return cacheNumber;
    }

    private Number(int number) {
        validateNumber(number);
        this.number = number;
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
