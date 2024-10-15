package lotto.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class LottoResultAnalyzer {
    private final List<WinningResult> winningResults;

    public LottoResultAnalyzer() {
        winningResults = Arrays.asList(
                new WinningResult(PrizeMoney.THREE),
                new WinningResult(PrizeMoney.FOUR),
                new WinningResult(PrizeMoney.FIVE),
                new WinningResult(PrizeMoney.SIX)
        );
    }

    public List<WinningResult> analyzer(List<Lotto> lottos, Set<Integer> winnersNumber) {
        for (Lotto lotto : lottos) {
            PrizeMoney prizeMoney = PrizeMoney.findByCount(lotto.matchCount(winnersNumber));
            process(prizeMoney);
        }
        return winningResults;
    }

    private void process(PrizeMoney prizeMoney) {
        if (prizeMoney == PrizeMoney.LOSE) {
            return;
        }
        winningResults.stream().filter(w -> w.isSame(prizeMoney)).forEach(w -> increase(w));
    }

    private void increase(WinningResult search) {
        search.increase();
    }
}
