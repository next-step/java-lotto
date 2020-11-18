package lotto.domain;

import java.io.PrintWriter;

public class Lotto {

    public static final int PRICE = 1000;

    private LottoNumber number;

    public Lotto(LottoNumber number) {
        this.number = number;
    }

    public int getMatchedNumberCount(NumberMatcher numberMatcher) {
        return this.number.getMatchedNumberCount(numberMatcher);
    }

    public void printNumber(PrintWriter writer) {
        this.number.print(writer);
    }
}
