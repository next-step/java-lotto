package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class PrizeStatus {

    private HashMap<Rank, Integer> prizeStatus = new HashMap<>();
    private int totalEarning;

    public PrizeStatus(LottoGame lottoGame) {
        List<LottoTicket> tickets = lottoGame.tickets();
        int totalProfit = 0;
        setupPrizeStatus();

        for (int i = 0; i < tickets.size(); i++) {
            int updatedTotalProfit = updatePrizeStatus(tickets.get(i), lottoGame.winnerNumbers());
            totalProfit += updatedTotalProfit;
        }
        this.totalEarning = totalProfit;
    }

    public PrizeStatus(LottoFactory lottoFactory, WinnerNumbers winnerNumbers) {
        int totalProfit = 0;
        setupPrizeStatus();

        for (int i = 0; i < lottoFactory.numberOfPurchasedTicket(); i++) {
            int updatedTotalProfit = updatePrizeStatus(lottoFactory.selectTicket(i), winnerNumbers);
            totalProfit += updatedTotalProfit;
        }
        this.totalEarning = totalProfit;
    }

    private int updatePrizeStatus(LottoTicket lottoTicket, WinnerNumbers winnerNumbers) {
        int totalProfit = 0;
        int totalMatchedCount = lottoTicket.calculateTotalMatchedCount(winnerNumbers);

        if (totalMatchedCount == 3) {
            int currentNumOfPrize = getCurrentNumOfPrize(totalMatchedCount, false);
            this.prizeStatus.put(Rank.FIFTH, currentNumOfPrize + 1);
            totalProfit += 5000;
        }

        if (totalMatchedCount == 4) {
            int currentNumOfPrize = getCurrentNumOfPrize(totalMatchedCount, false   );
            this.prizeStatus.put(Rank.FOURTH, currentNumOfPrize + 1);
            totalProfit += 50000;
        }

        if (totalMatchedCount == 5) {
            int currentNumOfPrize = getCurrentNumOfPrize(totalMatchedCount, false);
            this.prizeStatus.put(Rank.THIRD, currentNumOfPrize + 1);
            totalProfit += 1500000;
        }

        if (totalMatchedCount == 5 && lottoTicket.isMatchedWithBonusNum(winnerNumbers)) {
            int currentNumOfPrize = getCurrentNumOfPrize(totalMatchedCount, true);
            this.prizeStatus.put(Rank.SECOND, currentNumOfPrize + 1);
            totalProfit += 3000000;
        }

        if (totalMatchedCount == 6) {
            int currentNumOfPrize = getCurrentNumOfPrize(totalMatchedCount, false);
            this.prizeStatus.put(Rank.FIRST, currentNumOfPrize + 1);
            totalProfit += 2000000000;
        }
        return totalProfit;
    }

    public int getCurrentNumOfPrize(int totalMatchedCount, boolean isBonusWinner) {
        return prizeStatus.get(Rank.of(totalMatchedCount, isBonusWinner));
    }

    private void setupPrizeStatus() {
        prizeStatus.put(Rank.FIFTH, 0);
        prizeStatus.put(Rank.FOURTH, 0);
        prizeStatus.put(Rank.THIRD, 0);
        prizeStatus.put(Rank.SECOND, 0);
        prizeStatus.put(Rank.FIRST, 0);
    }

    public double calculateProfit(int purchasedAmt) {
        double revenueRate = Math.floor((totalEarning / (double) purchasedAmt) * 100) / 100;
        return revenueRate;
    }
}