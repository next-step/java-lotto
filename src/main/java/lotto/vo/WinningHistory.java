package lotto.vo;

import lotto.domain.WinningRank;

import java.util.List;

public class WinningHistory {

    private final List<WinningRank> history;

    private WinningHistory(List<WinningRank> history) {
        this.history = history;
    }

    public static WinningHistory create(List<WinningRank> history) {
        return new WinningHistory(history);
    }
}
