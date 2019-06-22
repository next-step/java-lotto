package step2.iksoo.lottoAuto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private static final int LOTTO_SIZE = 6;

    private List<Integer> luckyNumbers;

    Lotto() {
        this(new RandomNumberCreator().getLotto(LOTTO_SIZE));
    }

    Lotto(List<Integer> numbers) {
        this.luckyNumbers = numbers;
        sortLotto();
    }

    private void sortLotto() {
        Collections.sort(this.luckyNumbers);
    }

    public int checkNumberOfMatches(List<Integer> winNumbers) {
        return (int) luckyNumbers
                .stream()
                .filter(winNumbers::contains)
                .count();
    }

    public boolean isNumSize(int numSize) {
        return this.luckyNumbers.size() == numSize;
    }

    public List<Integer> getLotto() {
        return this.luckyNumbers;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return LOTTO_SIZE == lotto.LOTTO_SIZE &&
                Objects.equals(lottery, lotto.lottery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LOTTO_SIZE, lottery);
    }
}
