package lotto.domain;

import lotto.util.NullCheckUtil;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningStatistics {

    private final List<WinningInformation> winningInformations;

    public WinningStatistics(final List<WinningInformation> winningInformations) {
        NullCheckUtil.validate(winningInformations);
        this.winningInformations = winningInformations;
    }

    public static WinningStatistics of(final List<Lotto> lottos, final Lotto lastWeekWinningLotto, BonusBall bonusBall) {
        List<WinningInformation> winningInformations = lottos.stream()
                .map(lotto -> WinningInformation.of(lotto.countMatches(lastWeekWinningLotto), lotto.isMatch(bonusBall)))
                .collect(Collectors.toList());
        return new WinningStatistics(winningInformations);
    }

    public int countSame(WinningInformation winningInformation) {
        return Collections.frequency(this.winningInformations, winningInformation);
    }

    public BigDecimal calculateYield(Money purchaseAmount) {
        List<Money> monies = winningInformations.stream()
                .map(WinningInformation::getAmount)
                .collect(Collectors.toList());
        Money totalWinningAmount = Money.sumMoney(monies);
        return totalWinningAmount.divide(purchaseAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningStatistics that = (WinningStatistics) o;
        return Objects.equals(winningInformations, that.winningInformations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningInformations);
    }
}
