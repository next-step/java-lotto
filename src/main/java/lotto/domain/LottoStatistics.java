package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {
    private final Map<Rank, Integer> winningResults;
    private BigDecimal revenueRate;

    public LottoStatistics() {
        this.winningResults = new HashMap<>();
        this.revenueRate = new BigDecimal(String.valueOf(0));
    }

    public void init(final LottoGame lottoGame, final Lotto winnerLotto) {
        makeWinningResults(lottoGame.getLottoes(), winnerLotto);
        makeRevenueRate(lottoGame.getMoney());
    }

    private void makeWinningResults(final Lottoes lottoes, final Lotto winnerLotto) {
        Arrays.stream(Rank.values())
                .forEach(rank -> winningResults.put(rank, lottoes.getRankCount(winnerLotto, rank)));
    }

    private void makeRevenueRate(final int amount) {
        BigDecimal totalPrizeMoney = new BigDecimal(String.valueOf(getTotalPrizeMoney()));
        this.revenueRate = totalPrizeMoney.divide(new BigDecimal(String.valueOf(amount)), 2, RoundingMode.HALF_EVEN);
    }

    private int getTotalPrizeMoney() {
        int totalPrizeMoney = 0;
        for (Rank rank : winningResults.keySet()) {
            totalPrizeMoney += rank.getPrizeMoney() * winningResults.get(rank);
        }
        return totalPrizeMoney;
    }

    public Map<Rank, Integer> getWinningResults() {
        return Collections.unmodifiableMap(winningResults);
    }

    public BigDecimal getRevenueRate() {
        return revenueRate;
    }
}
