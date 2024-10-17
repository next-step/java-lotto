package lottogame.domain;

import java.util.List;

public class Lotto {
    private LottoNumbers numbers;

    public Lotto(LottoStrategy strategy) {
        this.numbers = strategy.generateLottoNumbers();
    }

    public int countMatchingNumbers(Lotto other) {
        return this.numbers.countMatchingNumbers(other.numbers);
    }

    public boolean isMatchingBonus(LottoNumber number) {
        return this.numbers.isMatchingBonus(number);
    }

    public List<LottoNumber> getNumbers() {
        return numbers.getLottoNumbers();
    }


}

