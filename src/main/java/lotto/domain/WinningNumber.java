package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private final List<LottoNumber> numbers;

    public WinningNumber(final List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public Matches countMatches(final List<Lotto> lottos) {
        List<Integer> countMatches = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int countMatch = lotto.countMatch(numbers);
            countMatches.add(countMatch);
        }
        return new Matches(countMatches);
    }
}
