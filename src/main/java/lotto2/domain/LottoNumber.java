package lotto2.domain;

/**
 * 역할 - 1~45 사이 숫자라는 것을 확인. 보장한다.
 */
public class LottoNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if ( number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("잘못된 로또 번호 입니다.");
        }
    }
}