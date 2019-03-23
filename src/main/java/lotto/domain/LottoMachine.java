package lotto.domain;

import java.util.Set;

public class LottoMachine {

    public static LottoList purchase(final long purchaseAmount) {
        LottoMoney lottoMoney = new LottoMoney(purchaseAmount);

        return new LottoList(lottoMoney.countOfLotto());
    }

    public static WinningResults getWinningResults(final LottoList lottos, final WinningLotto winningLotto) {
        WinningResults winningResults = new WinningResults();

        Prize[] prizes = Prize.values();
        for (int i = 0; i < prizes.length; i++) {
            winningResults.put(prizes[i],
                    new WinningResult(prizes[i], lottos.find(prizes[i], winningLotto)));
        }

        return winningResults;
    }

    public static double getEarningsRate(final WinningResults winningResults, final long purchaseAmount) {
        long totalPrizeMoney = 0;

        Set<Prize> winningResultsKeys = winningResults.keySet();

        for (Prize prize : winningResultsKeys) {
            totalPrizeMoney += prize.getMoney() * winningResults.get(prize).getMatchCount();
        }

        return totalPrizeMoney / (double) purchaseAmount;
    }
}
