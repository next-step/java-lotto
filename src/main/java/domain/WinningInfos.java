package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WinningInfos {
    private final List<WinningInfo> winningInfos;

    public static WinningInfos of() {
        List<WinningInfo> list = new ArrayList<>(Arrays.asList(
                WinningInfo.of(Rank.FIFTH),
                WinningInfo.of(Rank.FORTH),
                WinningInfo.of(Rank.THIRD),
                WinningInfo.of(Rank.SECOND),
                WinningInfo.of(Rank.FIRST)
        ));
        return new WinningInfos(list);
    }

    private WinningInfos(List<WinningInfo> winningInfos) {
        this.winningInfos = winningInfos;
    }

    public List<WinningInfo> getWinningInfos() {
        return winningInfos;
    }

    public void update(Rank rank) {
        if (rank.equals(Rank.MISS)) {
            return;
        }
        WinningInfo winningInfo = winningInfos.stream()
                .filter(e -> e.getRank().equals(rank))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        winningInfo.increaseHitNumber();
    }

    public BigDecimal getTotalWinningMoney() {
        return winningInfos.stream()
                .map(WinningInfo::getMultiplyWinningMoney)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
