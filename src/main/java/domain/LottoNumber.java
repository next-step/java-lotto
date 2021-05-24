package domain;

import java.util.Objects;

public class LottoNumber {

    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private final static String LOTTO_NUMBER_VALIDATION_MESSAGE = "로또 숫자는 1 ~ 45 사이의 숫자만 가능합니다.";
    private final int lottoNumber;

    public LottoNumber(int number) {
        validation(number);
        lottoNumber = number;
    }

    private void validation(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(LOTTO_NUMBER_VALIDATION_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
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

    public int ascendingSort(LottoNumber comparisonObject) {
        return this.lottoNumber - comparisonObject.lottoNumber;
    }

    public boolean isMatchBall(LottoTicket lottoTicket) {
        return lottoTicket.contains(this);
    }
}