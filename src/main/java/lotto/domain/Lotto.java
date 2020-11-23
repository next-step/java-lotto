package lotto.domain;

import java.io.PrintWriter;
import java.util.Objects;

public class Lotto {

    public static final int PRICE = 1000;

    private LottoNumber number;

    public Lotto(LottoNumber number) {
        this.number = number;
    }

    public long getMatchedNumberCount(NumberMatcher numberMatcher) {
        return this.number.getMatchedNumberCount(numberMatcher);
    }

    public void printNumber(PrintWriter writer) {
        this.number.print(writer);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(number, lotto.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
