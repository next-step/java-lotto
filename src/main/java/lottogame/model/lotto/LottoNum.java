package lottogame.model.lotto;

import java.util.Objects;

public class LottoNum implements Comparable<LottoNum>{
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;

    private final int num;

    public LottoNum(int num) {
        if (isOutOfLottoRange(num)) {
            throw new IllegalArgumentException("1부터 45사이의 숫자만 입력해주세요.");
        }

        this.num = num;
    }

    private boolean isOutOfLottoRange(int num) {
        return num < MIN_NUM || num > MAX_NUM;
    }

    public int value() {
        return num;
    }

    @Override
    public int compareTo(LottoNum o) {
        return Integer.compare(this.num, o.num);
    }

    public String toString() {
        return String.valueOf(num);
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
