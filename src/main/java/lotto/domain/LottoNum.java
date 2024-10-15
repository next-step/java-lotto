package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNum implements Comparable<LottoNum> {

    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_END_NUMBER = 45;

    private final int num;

    public LottoNum(int num) {
        isBoundLottoNumber(num);
        this.num = num;
    }

    private static void isBoundLottoNumber(int num) {
        if (num < LOTTO_START_NUMBER || num > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("로또 번호의 범위는 1 ~ 45 여야 합니다.");
        }
    }

    public LottoNum(String num) {
        this(Integer.parseInt(num));
    }

    public static List<LottoNum> getLottoNumbers() {
        List<LottoNum> result = new ArrayList<>();
        IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
                .forEach(num -> result.add(new LottoNum(num)));
        return result;
    }

    @Override
    public int compareTo(LottoNum lottoNum) {
        return Integer.compare(this.num, lottoNum.num);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        LottoNum lottoNum = (LottoNum) object;
        return num == lottoNum.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
}
