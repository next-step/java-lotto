package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static lotto.domain.Cashier.LOTTO_PURCHASING_UNIT;

public class WinningStatistics {

    private final List<WinningInformation> winningInformations;

    public WinningStatistics(final List<WinningInformation> winningInformations) {
        this.winningInformations = winningInformations;
    }

    public static WinningStatistics of(final List<Lotto> lottos, final Lotto lastWeekWinningLotto) {
        List<WinningInformation> winningInformations = lottos.stream()
                .map(lotto -> WinningInformation.of(lotto.countMatches(lastWeekWinningLotto)))
                .collect(Collectors.toList());
        return new WinningStatistics(winningInformations);
    }

    public int countSame(WinningInformation winningInformation) {
        return Collections.frequency(this.winningInformations, winningInformation);
    }

    public double calculateYield() {
        return (double) WinningInformation.sumAmounts(winningInformations) / (double) purchaseAmount();
    }

    private int purchaseAmount() {
        return winningInformations.size() * LOTTO_PURCHASING_UNIT;
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
