package lotto.domain;

import java.util.HashMap;

public class PrizeStatus {

    private HashMap<Integer, Integer> prizeStatus = new HashMap<>();
    private int totalEarning;

    public PrizeStatus(LottoTickets lottoTickets, WinnerNumbers winnerNumbers) {
        int totalProfit = 0;
        setupPrizeStatus();

        for (int i = 0; i < lottoTickets.numberOfPurchasedTicket(); i++) {
            int totalMatchedCount = lottoTickets.tickets().get(i).calculateTotalMatchedCount(winnerNumbers);
            int updatedTotalProfit = updatePrizeStatus(totalMatchedCount, totalProfit);
            totalProfit = updatedTotalProfit;
        }
        this.totalEarning = totalProfit;
    }

    private int updatePrizeStatus(int totalMatchedCount, int totalProfit) {
        if (totalMatchedCount == 3) {
            int currentNumOfPrize = getCurrentNumOfPrize(totalMatchedCount);
            this.prizeStatus.put(totalMatchedCount, currentNumOfPrize + 1);
            totalProfit += 5000;
        }

        if (totalMatchedCount == 4) {
            int currentNumOfPrize = getCurrentNumOfPrize(totalMatchedCount);
            this.prizeStatus.put(totalMatchedCount, currentNumOfPrize + 1);
            totalProfit += 50000;
        }

        if (totalMatchedCount == 5) {
            int currentNumOfPrize = getCurrentNumOfPrize(totalMatchedCount);
            this.prizeStatus.put(totalMatchedCount, currentNumOfPrize + 1);
            totalProfit += 1500000;
        }

        if (totalMatchedCount == 6) {
            int currentNumOfPrize = getCurrentNumOfPrize(totalMatchedCount);
            this.prizeStatus.put(totalMatchedCount, currentNumOfPrize + 1);
            totalProfit += 2000000000;
        }
        return totalProfit;
    }

    public int getCurrentNumOfPrize(int totalMatchedCount) {
        return prizeStatus.get(totalMatchedCount);
    }

    private void setupPrizeStatus() {
        prizeStatus.put(Rank.FOURTH.matchCount(), 0);
        prizeStatus.put(Rank.THIRD.matchCount(), 0);
        prizeStatus.put(Rank.SECOND.matchCount(), 0);
        prizeStatus.put(Rank.FIRST.matchCount(), 0);
    }

    public double calculateProfit(int purchasedAmt) {
        double revenueRate = Math.floor((totalEarning / (double) purchasedAmt) * 100) / 100;
        return revenueRate;
    }
}