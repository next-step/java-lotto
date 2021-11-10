package lotto.vo;

public class LottoNumber {

    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "입력 값이 숫자가 아닙니다.";

    private final int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber create(String input) {
        if(input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION_MESSAGE);
        }


        return new LottoNumber(Integer.parseInt(input));
    }
}
