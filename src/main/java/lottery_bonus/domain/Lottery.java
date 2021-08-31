package lottery_bonus.domain;

import java.util.List;

public final class Lottery {
    private List<Integer> quickPicks;

    public Lottery(final List<Integer> quickPicks) {
        this.quickPicks = quickPicks;
    }

}
