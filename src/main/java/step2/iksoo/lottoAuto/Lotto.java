package step2.iksoo.lottoAuto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.toIntExact;

public class Lotto {
    private final int LOTTO_SIZE = 6;

    private List<Integer> luckyNumbers;

    protected Lotto() {
        this.luckyNumbers = new ArrayList<>();
        this.makeLotto();
    }

    protected Lotto(List<Integer> numbers) {
        this.luckyNumbers = numbers;
        Collections.sort(this.luckyNumbers);
    }

    private void makeLotto() {
        this.luckyNumbers = new RandomNumberCreator().getLotto(this.LOTTO_SIZE);
        Collections.sort(this.luckyNumbers);
    }

    protected int checkNumberOfMatches(List<Integer> winNumbers) {
        return toIntExact(winNumbers
                .stream()
                .filter(number -> this.luckyNumbers.contains(number))
                .count());
    }

    protected boolean isNumSize(int numSize) {
        return this.luckyNumbers.size() == numSize;
    }

    protected void printLotto() {
        OutputView.printTextln(this.luckyNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return LOTTO_SIZE == lotto.LOTTO_SIZE &&
                Objects.equals(luckyNumbers, lotto.luckyNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LOTTO_SIZE, luckyNumbers);
    }
}
