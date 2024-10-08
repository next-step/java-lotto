package lotto.domain;

public class LottoNumber {
    private static final int MINIMUM_VALUE = 1;
    private static final int MAXIMUM_VALUE = 45;
    private static final String INCORRECT_NUMBER_RANGE_ERROR_MESSAGE = "유효한 로또번호의 범위가 아닙니다.";
    private final int number;


    public LottoNumber(final int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(final int number){
        if(number < MINIMUM_VALUE || number > MAXIMUM_VALUE){
            throw new IllegalArgumentException(INCORRECT_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }
}
