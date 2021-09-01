package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;
    public static final String LOTTO_NUMBER_ERROR_MESSAGE = "로또번호는"+LOTTO_START_NUMBER+"과 " + LOTTO_LAST_NUMBER + "사이 숫자이어야 합니다.";

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < LOTTO_START_NUMBER || lottoNumber > LOTTO_LAST_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSAGE);
        }
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

    @Override
    public int compareTo(LottoNumber o) {
        return this.lottoNumber - o.lottoNumber;
    }
}
