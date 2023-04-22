package lotto.domain;

import java.util.List;

public class Winners {
    private final int countFitft;
    private final int countforth;
    private final int countThird;
    private final int countFirst;

    public Winners(int countFirst, int toBeDiscussion, int countThird, int countforth, int countFitft) {
        this.countFirst = countFirst;
        this.countThird = countThird;
        this.countforth = countforth;
        this.countFitft = countFitft;
    }

    public List<Integer> winnerCount() {
        return List.of(countFirst, countThird, countforth, countFitft);
    }
}
