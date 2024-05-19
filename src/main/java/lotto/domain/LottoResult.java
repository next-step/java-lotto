package lotto.domain;

import java.util.Map;

import static lotto.enums.PrizeMoney.*;

public class LottoResult {
    private final Lotto lotto;
    private final WinningLotto winningLotto;

    public LottoResult(Lotto lotto, WinningLotto winningLotto) {
        this.lotto = lotto;
        this.winningLotto = winningLotto;
    }

    public Map<Integer, Integer> matchWinningNumberCount(){
        return lotto.match(winningLotto.lastWinningNumbers());
    }

    public double rateOfReturn() {
        Map<Integer, Integer> winningCounts = matchWinningNumberCount();

        double totalPrize = 0;
        if (winningCounts.containsKey(3)) totalPrize += winningCounts.get(3) * THREE_MATCHES.prizeMoney();
        if (winningCounts.containsKey(4)) totalPrize += winningCounts.get(4) * FOUR_MATCHES.prizeMoney();
        if (winningCounts.containsKey(5)) totalPrize += winningCounts.get(5) * FIVE_MATCHES.prizeMoney();
        if (winningCounts.containsKey(6)) totalPrize += winningCounts.get(6) * SIX_MATCHES.prizeMoney();

        return totalPrize / lotto.count() * 1_000;
    }
}
