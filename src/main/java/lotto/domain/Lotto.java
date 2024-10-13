package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    public static final int LOTTO_NUMBERS_CARDINALITY = 6;
    public static final int LOTTO_PRICE = 1000;

    private final int id;
    private final LottoNumbers numbers;

    private Lotto(int id, LottoNumbers numbers) {
        this.id = id;
        this.numbers = numbers;
    }

    public static Lotto valueOf(int id, List<Integer> numbers) {
        return new Lotto(id, LottoNumbers.valueOf(numbers));
    }

    public static Lotto newInstance(int id, LottoNumberSelectionStrategy strategy) {
        return new Lotto(id, strategy.select());
    }

    public List<Integer> getNumbers() {
        return this.numbers.value();
    }

    public int getId() {
        return this.id;
    }

    public int getMatchCount(LottoNumbers winningNumbers) {
        int matchCount = 0;
        List<Integer> winningNumberList = winningNumbers.value();
        for (int number : numbers.value()) {
            matchCount = updateMatchCount(number, winningNumberList, matchCount);
        }
        return matchCount;
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.value().contains(bonusNumber);
    }

    private int updateMatchCount(int number, List<Integer> winningNumberList, int matchCount) {
        if (winningNumberList.contains(number)) {
            matchCount++;
        }
        return matchCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(getId(), lotto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
