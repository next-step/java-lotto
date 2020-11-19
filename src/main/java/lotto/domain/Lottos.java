package lotto.domain;

import lotto.domain.game.Lotto;
import lotto.domain.winning.WinningChecker;
import lotto.domain.winning.WinningNumber;
import lotto.domain.winning.WinningStatistics;

import java.util.List;
import java.util.Objects;

/**
 * Created By mand2 on 2020-11-19.
 */
public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public WinningStatistics winningStatistics(WinningNumber winningNumber) {
        checkWinningResult(winningNumber);
        return accumulateStatistics();
    }

    private void checkWinningResult(WinningNumber winningNumber) {
        WinningChecker winningChecker = WinningChecker.of(winningNumber);
        for (Lotto lotto : this.lottos) {
            lotto.lottoResult(winningChecker);
        }
    }

    private WinningStatistics accumulateStatistics() {
        WinningStatistics winningStatistics = new WinningStatistics();
        this.lottos.forEach(lotto -> {
                    winningStatistics.add(lotto.winningResult());
                });
        return winningStatistics;
    }

    public List<Lotto> list() {
        return this.lottos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

}
