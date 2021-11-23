package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Dollars {

    public static final String ILLEGAL_RANGE_ERROR_MESSAGE = "1000이상의 값이 필요합니다.";
    public static final String NOT_ENOUGH_MONEY_EXCEPTION = "금액이 부족합니다.";
    public static final int DOLLAR_UNIT = 1000;
    private static final int MIN_COUNT = 1;

    private final int count;

    public Dollars(int won) {
        count = toCount(won);
    }

    private int toCount(int won) {
        int count = won / DOLLAR_UNIT;
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException(ILLEGAL_RANGE_ERROR_MESSAGE);
        }
        return count;
    }

    public int getCount() {
        return count;
    }

    public long won() {
        return (long) count * DOLLAR_UNIT;
    }

    public void checkEnoughMoney(List<LottoNumbers> lottoLines) {
        if (count < lottoLines.size()) {
            throw new IllegalArgumentException(NOT_ENOUGH_MONEY_EXCEPTION);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dollars dollars = (Dollars) o;
        return count == dollars.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }

    @Override
    public String toString() {
        return "Dollars{" +
                "count=" + count +
                '}';
    }
}
