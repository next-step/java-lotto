package lotto;

import java.util.Collections;
import java.util.StringJoiner;

import lotto.data.LottoNumbers;

public class Lotto {
    private final LottoNumbers numbers;

    public Lotto() {
        this.numbers = new LottoNumbers(LottoNumberGenerator.sixNumberGenerator());
    }

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public int matchCount(LottoNumbers winningNumbers) {
        return numbers.matchCount(winningNumbers);
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",");
        Collections.sort(numbers.getNumbers());

        for (int num : numbers.getNumbers()) {
            sj.add(String.valueOf(num));
        }

        return "[ " +sj.toString() + " ]";
    }
}
