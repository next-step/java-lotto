package lottogame.model.lotto;

import static java.util.stream.IntStream.range;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNum implements Comparable<LottoNum> {

    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;

    private static final Map<Integer, LottoNum> CACHE = new HashMap<>();

    private final int num;

    static {
        range(MIN_NUM, MAX_NUM + 1).forEach(
                num -> CACHE.put(num, new LottoNum(num))
        );
    }

    private LottoNum(int num) {
        if (isOutOfLottoRange(num)) {
            throw new IllegalArgumentException("1부터 45사이의 숫자만 입력해주세요.");
        }

        this.num = num;
    }

    public static LottoNum getInstance(int num) {
        if (isOutOfLottoRange(num)) {
            throw new IllegalArgumentException("1부터 45사이의 숫자만 입력해주세요.");
        }

        return CACHE.get(num);
    }

    private static boolean isOutOfLottoRange(int num) {
        return num < MIN_NUM || num > MAX_NUM;
    }

    public String toString() {
        return String.valueOf(num);
    }

    @Override
    public int compareTo(LottoNum o) {
        return Integer.compare(num, o.num);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNum lottoNum = (LottoNum) o;
        return num == lottoNum.num;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(num);
    }
}
