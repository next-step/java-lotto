package lotto.domain;

import java.util.Objects;

public class LottoCount {
    private int count;


    public LottoCount(String count) {
        this(Integer.parseInt(count));
    }

    public LottoCount(int count) {
       this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoCount that = (LottoCount) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(count);
    }
}
