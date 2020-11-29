package lotto.domain;

import java.util.Objects;

import static lotto.domain.LottoGameConfig.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoGameConfig.MIN_LOTTO_NUMBER;

public final class LottoNumber implements Comparable<LottoNumber> {

    private final int number;

    public LottoNumber(int number){
        validateLottoNumber(number);
        this.number = number;
    }

    private void validateLottoNumber(int number) {
        if(number < MIN_LOTTO_NUMBER){
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_LOTTO_NUMBER.getErrorMessage());
        }

        if(number > MAX_LOTTO_NUMBER){
            throw new IllegalArgumentException(LottoErrorMessage.ILLEGAL_LOTTO_NUMBER.getErrorMessage());
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber o) {

        if(this.number < o.getNumber()) {
            return -1;
        }

        if(this.number > o.getNumber()) {
            return 1;
        }

        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
