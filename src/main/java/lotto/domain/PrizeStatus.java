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
        int totalMatchedCount = lottoTicket.calculateTotalMatchedCount(winnerNumbers);
        boolean isBonusWinner = lottoTicket.isMatchedWithBonusNum(winnerNumbers);
        int currentNumOfPrize = getCurrentNumOfPrize(totalMatchedCount, isBonusWinner);
        Rank userRank = Rank.of(totalMatchedCount, isBonusWinner);

        this.prizeStatus.put(userRank, currentNumOfPrize +1);

        return userRank.winningMoney();
    }

    public int getCurrentNumOfPrize(int totalMatchedCount, boolean isBonusWinner) {
        Rank selectedRank = Rank.of(totalMatchedCount, isBonusWinner);
        if (totalMatchedCount >= 3) {
            return prizeStatus.get(selectedRank);
        }
        return prizeStatus.getOrDefault(selectedRank, 0);
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