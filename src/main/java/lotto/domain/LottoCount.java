package lotto.domain;

import lotto.exception.LottoNumberException;

import java.util.Objects;

public class LottoCount {

    private static final String ERR_NUMBER_FORMAT = "숫자 형식 데이터가 아닙니다";

    private final int count;

    private LottoCount(int count) {
        this.count = count;
    }

    private LottoCount(String count) {
        try {
            this.count = Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new LottoNumberException(ERR_NUMBER_FORMAT);
        }
    }

    public static LottoCount of(int number) {
        return new LottoCount(number);
    }

    public static LottoCount of(String number) {
        return new LottoCount(number);
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoCount lottoCount1 = (LottoCount) o;
        return count == lottoCount1.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
