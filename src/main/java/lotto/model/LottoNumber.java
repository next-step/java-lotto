package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final String NUMBER_CONDITION_MESSAGE = "로또번호는 1부터 45사이입니다";
    private final static int START_NUM = 1;
    private final static int LAST_NUM = 45;
    private static final List<LottoNumber> CACHE = new ArrayList<>();

    static {
        for (int i = START_NUM; i <= LAST_NUM; i++) {
            CACHE.add(new LottoNumber(i));
        }
    }

    private final int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    public static LottoNumber valueOf(final int number) {
        LottoNumber lottoNumber = CACHE.get(number - START_NUM);
        if (Objects.isNull(lottoNumber)) {
            lottoNumber = new LottoNumber(number);
        }
        return lottoNumber;
    }

    private void validateNumber(int number) {
        if (number < START_NUM || number > LAST_NUM) {
            throw new IllegalArgumentException(NUMBER_CONDITION_MESSAGE);
        }
    }

    public int getNumber() {
        return number;
    }

    public static List<LottoNumber> values() {
        return CACHE;
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
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return getNumber() - o.getNumber();
    }
}
