package lotto.domain;

public class LottoNumber implements  Comparable<LottoNumber>{
    private int value;

    public LottoNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.value-o.value;
    }
}
