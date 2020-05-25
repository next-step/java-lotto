package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {

    private final static int ZERO_NUMBER = 0;

    private int value;

    private LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    public static LottoNumber create(int value) {
        return new LottoNumber(value);
    }

    private void validate(int value) {
        if (value <= ZERO_NUMBER) {
            throw new RuntimeException("0 이하의 값을 입력했습니다.");
        }
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return Integer.compare(value, lottoNumber.value);
    }

    public int getValue() {
        return value;
    }

}
