package lotto.domain;

import java.util.Objects;
import lotto.exception.NumberNullPointerException;
import lotto.exception.TicketNumberOutBoundException;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final Integer MINIMUM_NUMBER = 1;
    private static final Integer MAXIMUM_NUMBER = 45;

    private final Integer lottoNumber;

    private LottoNumber(Integer lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(Integer number) {
        validNumber(number);
        return new LottoNumber(number);
    }

    private static void validNumber(Integer number) {
        if (number == null) {
            throw new NumberNullPointerException();
        }
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new TicketNumberOutBoundException(MINIMUM_NUMBER, MAXIMUM_NUMBER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.lottoNumber - o.lottoNumber;
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
