package domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
                .filter(info -> info.getRank().equals(rank))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
        winningInfo.increaseWinningNumber();
    }

    public double getBenefitRate(LottoMoney lottoMoney) {
        return getTotalWinningMoney()
                .divide(lottoMoney.getMoney(), 2, RoundingMode.DOWN)
                .doubleValue();
    }

    protected BigDecimal getTotalWinningMoney() {
        return winningInfos.stream()
                .map(WinningInfo::getMultiplyWinningMoney)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
