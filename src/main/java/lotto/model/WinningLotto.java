package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class WinningLotto {
    private Set<Integer> numbers;
    private int bonusNumber;

    private WinningLotto(Set<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto from(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(new HashSet<>(numbers), bonusNumber);
    }

    public Rank getRank(Lotto userLotto) {
        return Rank.valueOf(userLotto.getMatchCount(numbers), userLotto.isContain(bonusNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return bonusNumber == that.bonusNumber &&
                Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, bonusNumber);
    }
}
