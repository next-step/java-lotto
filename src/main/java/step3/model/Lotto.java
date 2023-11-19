package step3.model;

import java.util.List;

import static step3.enumeration.LottoRank.*;

public class Lotto {

    private final LottoNumbers numbers;

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public int getLottoWinner(List<Integer> winNumbers) {
        return (int) winNumbers.stream()
                .filter(this.numbers.getNumbers()::contains)
                .count();
    }

    public int getBonusNumberCount(List<Integer> winNumbers, int bonusNumber) {
        int count = (int) winNumbers.stream()
                .filter(this.numbers.getNumbers()::contains)
                .count();

        if (ALL_BONUS_RANK.contains(count) && this.numbers.getNumbers().contains(bonusNumber)) {
            return count;
        }

        return ZERO.getMatch();
    }

    @Override
    public String toString() {
        return this.numbers.getNumbers().toString();
    }
}
