package lotto;

import java.util.StringJoiner;

import lotto.data.LottoNumbers;

public class Lotto {
    private final LottoNumbers numbers;

    public Lotto() {
        this.numbers = LottoNumberGenerator.sixNumberGenerator();
    }

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public int matchCount(LottoNumbers winningNumbers) {
        return numbers.matchCount(winningNumbers);
    }

    public boolean isMatchBonus(int bonus) {
        return numbers.isMatchBonus(bonus);
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",");

        for (int num : numbers.getNumbers()) {
            sj.add(String.valueOf(num));
        }

        return "[ " +sj.toString() + " ]";
    }
}
