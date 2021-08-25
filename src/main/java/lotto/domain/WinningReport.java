package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningReport {
    private static final int TICKET_PRICE = 1000;

    private Map<Award, Integer> resultMap = new HashMap<>();
    private double rateOfReturn;

    public Map<Award, Integer> awardResult() {
        return resultMap;
    }

    public void checkWinning(LottoPaper lottoPaper, List<LottoNumber> winningNumbers) {
        List<Lotto> lottos = lottoPaper.getLottos();
        int totalWinningAmount = 0;

        for (Lotto lotto : lottos) {
            int match = lotto.match(winningNumbers);
            Award award = Award.valueOf(match);
            totalWinningAmount += award.winningMoney();
            resultMap.put(award, resultMap.getOrDefault(award, 0) + 1);
        }

        calculateRateOfReturn(totalWinningAmount, lottos.size() * TICKET_PRICE);
    }

    private void calculateRateOfReturn(int totalWinningAmount, int purchaseAmount) {
        this.rateOfReturn = (double) totalWinningAmount / (double) purchaseAmount;
    }

    public double rateOfReturn() {
        return Math.floor(rateOfReturn * 100) / 100;
    }
}
