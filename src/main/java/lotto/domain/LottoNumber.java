package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;

    private int lottoNumber;

    protected LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
        validateLottoNumber();
    }

    public static LottoNumber of(String lottoNumber) {
        validateParsable(lottoNumber);
        return new LottoNumber(Integer.parseInt(lottoNumber));
    }

    private static void validateParsable(String lottoNumber) {
        try {
            Integer.parseInt(lottoNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요");
        }
    }

    private void validateLottoNumber() {
        if ( lottoNumber < MINIMUM_LOTTO_NUMBER || lottoNumber > MAXIMUM_LOTTO_NUMBER ) {
            throw new IllegalArgumentException("로또 번호는 1 이상 45 이하입니다");
        }
    }

    public String parseString() {
        return String.valueOf(lottoNumber);
    }

    public int value() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
