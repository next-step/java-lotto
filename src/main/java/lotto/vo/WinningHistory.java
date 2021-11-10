package lotto.vo;

import lotto.domain.WinningRank;

import java.util.List;

public class WinningHistory {

    private final List<WinningRank> history;
    private final Money originMoney;
    private final Money winningMoney;

    private WinningHistory(List<WinningRank> history, Money originMoney, Money winningMoney) {
        this.history = history;
        this.originMoney = originMoney;
        this.winningMoney = winningMoney;
    }

    public static WinningHistory create(Money originMoney, List<WinningRank> history, Money winningMoney) {
        return new WinningHistory(history, originMoney, winningMoney);
    }

    public List<WinningRank> getHistory() {
        return history;
    }

    public Money getOriginMoney() {
        return originMoney;
    }

    public Money getWinningMoney() {
        return winningMoney;
    }
}
