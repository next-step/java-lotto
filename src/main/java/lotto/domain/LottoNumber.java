package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.exception.NumberNullPointerException;
import lotto.exception.TicketNumberOutBoundException;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final Integer MINIMUM_NUMBER = 1;
    private static final Integer MAXIMUM_NUMBER = 45;
    private static final Map<Integer, LottoNumber> LOTTO_NUMBERS;

    private final Integer lottoNumber;

    static {
        LOTTO_NUMBERS = new HashMap<>();
        for (int i = MINIMUM_NUMBER; i <= MAXIMUM_NUMBER; i++) {
            LOTTO_NUMBERS.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(Integer number) {
        validNumber(number);
        return LOTTO_NUMBERS.get(number);
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
