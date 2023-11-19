package step3.model;

import step3.enumeration.LottoRank;

import java.util.List;

import static step3.enumeration.LottoRank.*;

public class Lotto {

    private final LottoNumbers numbers;

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public String getLottoWinner(List<Integer> winNumbers, int bonusNumber) {
        int count = (int) winNumbers.stream()
                .filter(this.numbers.getNumbers()::contains)
                .count();

        if (SECOND.getMatch() == count && this.numbers.getNumbers().contains(bonusNumber)) {
            return SECOND.name();
        }

        return LottoRank.getName(count);
    }

    @Override
    public String toString() {
        return this.numbers.getNumbers().toString();
    }
}
