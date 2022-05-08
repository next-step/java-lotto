package step2.domain;

public class LottoNumber implements Comparable<LottoNumber>{
    private int value;

    public LottoNumber(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(value, o.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
