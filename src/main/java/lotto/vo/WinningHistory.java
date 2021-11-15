package lotto.vo;

import lotto.domain.WinningRank;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

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

    public Money getWinningMoney() {
        return winningMoney;
    }

    public Map<WinningRank, Long> getWinningMap() {
        return history.stream()
                .filter(winningRank -> !winningRank.equals(WinningRank.NO_RANK))
                .collect(groupingBy(winningRank -> winningRank, () -> new EnumMap<WinningRank, Long>(WinningRank.class), counting()));

    }

    public BigDecimal getYield() {
        return winningMoney.divide(originMoney);
    }
}
