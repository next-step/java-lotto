package lotto.domain;

import java.util.Objects;

public class LottoNum implements Comparable<LottoNum> {
    public static final int MIN = 1;
    public static final int MAX = 45;

    private int lottoNum;

    public LottoNum(int lottoNum) {
        this.lottoNum = lottoNum;

        checkNumRange();
    }

    public LottoNum(String lottoNumInput) {
        this(Integer.parseInt(lottoNumInput));
    }

    private void checkNumRange() {
        if (!isProperNumRange()) {
            throw new IllegalArgumentException("Out of range");
        }
    }

    private boolean isProperNumRange() {
        return lottoNum >= MIN && lottoNum <= MAX;
    }

    @Override
    public int compareTo(LottoNum inputNum) {
        return ascSort(inputNum.getLottoNum());
    }

    private int ascSort(int inputNum) {
        return lottoNum - inputNum;
    }

    public int getLottoNum() {
        return lottoNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNum lottoNum1 = (LottoNum) o;
        return lottoNum == lottoNum1.lottoNum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNum);
    }
}
