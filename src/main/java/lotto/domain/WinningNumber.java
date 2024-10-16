package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private final String value;

    public WinningNumber(final String value) {
        this.value = value;
    }

    public Matches countMatches(final List<Lotto> lottos) {
        List<Integer> countMatches = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int countMatch = lotto.countMatch(value);
            countMatches.add(countMatch);
        }
        return new Matches(countMatches);
    }
}
