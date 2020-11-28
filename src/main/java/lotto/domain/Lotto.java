package lotto.domain;

import java.io.PrintWriter;
import java.util.Objects;

public class Lotto {

    public static final int PRICE = 1000;

    private LottoNumbers number;

    public Lotto(String number){
        this.number = new LottoNumbers(number);
    }

    public Lotto(LottoNumbers number) {
        this.number = number;
    }

    long getMatchedNumberCount(LottoNumberMatcher lottoNumberMatcher) {
        return this.number.getMatchedNumberCount(lottoNumberMatcher);
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
