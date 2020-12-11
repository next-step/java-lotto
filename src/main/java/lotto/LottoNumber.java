package lotto;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int LOTTO_NUM_START = 1;
    public static final int LOTTO_NUM_END = 45;

    private int n;

    public LottoNumber(int n) {
        this.n = n;
    }

    public boolean isValidNumber() {
        return LOTTO_NUM_START <= n && n <= LOTTO_NUM_END;
    }

    public int getNumber() {
        return n;
    }

    @Override
    public int hashCode() {
        return n;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof LottoNumber) &&
                ((LottoNumber)obj).n == this.n;
    }

    @Override
    public String toString() {
        return "" + n;
    }

    @Override
    public int compareTo(LottoNumber rhs) {
        return Integer.compare(n, rhs.n);
    }

}
