package lotto.domain;

import lotto.exception.LottoNumberException;

import java.util.Objects;

public class LottoCount {

    private static final String ERR_NUMBER_FORMAT = "숫자 형식 데이터가 아닙니다";
    private static final String ERR_NEGATIVE_NUMBER = "로또 개수가 0 보다 작습니다.";


    private final int count;

    private LottoCount(int count) {
        this.count = count;
    }

    private LottoCount(String count) {
        try {
            this.count = Integer.parseInt(count);
            valid();
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

    public void valid() {
        if (this.count < 0) {
            throw new LottoNumberException(ERR_NEGATIVE_NUMBER);
        }
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
