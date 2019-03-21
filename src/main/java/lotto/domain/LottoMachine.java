package lotto.domain;

import java.util.Set;

public class LottoMachine {

    public static final long LOTTO_UNIT_PRICE = 1000;

    public static LottoList purchase(final long purchaseAmount) {
        if (purchaseAmount < LOTTO_UNIT_PRICE) {
            throw new IllegalArgumentException(LOTTO_UNIT_PRICE + " OR MORE");
        }

        return new LottoList((int) (purchaseAmount / LOTTO_UNIT_PRICE));
    }

    public static WinningResults getWinningResults(final LottoList lottos, final Lotto winningLotto) {
        WinningResults winningResults = new WinningResults();

        Prize[] prizes = Prize.values();
        for (int i = 0; i < prizes.length; i++) {
            winningResults.put(prizes[i], new WinningResult(prizes[i], lottos.find(prizes[i], winningLotto)));
        }

        return winningResults;
    }

    public static double getEarningsRate(final WinningResults winningResults, final long purchaseAmount) {
        long totalPrizeMoney = 0;

        Set<Prize> winningResultsKeys = winningResults.keySet();

        for (Prize prize : winningResultsKeys) {
            totalPrizeMoney += prize.getMoney() * winningResults.get(prize).getMatchingCount();
        }

        return totalPrizeMoney / (double) purchaseAmount;
    }
}
