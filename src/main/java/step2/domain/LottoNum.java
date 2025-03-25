package step2.domain;


import java.util.Objects;

public class LottoNum {
    private static final int MAX = 45;
    private static final int MIN = 1;
    private final int num;

    public LottoNum(int num) {
        valid(num);
        this.num = num;
    }

    private void valid(int num) {
        if (num > MAX || num < MIN) {
            throw new IllegalArgumentException("1과 45 사이의 정수값만 허용됩니다. ");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof LottoNum)) return false;
        LottoNum other = (LottoNum)obj;
        return num == other.num;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(num);
    }
}
