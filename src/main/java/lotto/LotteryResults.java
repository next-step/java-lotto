package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.WiningLottoTicket;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryResults {

    private Map<LottoRank, Integer> lottoResults;
    private double amount;

    public LotteryResults(WiningLottoTicket winingLottoTicket, List<LottoTicket> buyLottoTickets, int amount) {
        this.amount = amount;
        this.lottoResults = initLottoResultMap();
        saveLotteryResult(winingLottoTicket, buyLottoTickets);
    }

    public Map<LottoRank, Integer> getLottoResults() {
        return lottoResults;
    }

    private Map<LottoRank, Integer> initLottoResultMap() {
        lottoResults = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            lottoResults.put(rank, 0);
        }
        return lottoResults;
    }

    private void saveLotteryResult(WiningLottoTicket winingLottoTicket, List<LottoTicket> buyLottoTickets) {
        for (LottoTicket buyLottoTicket : buyLottoTickets) {
            LottoRank rank = getLottoRank(winingLottoTicket, buyLottoTicket);
            lottoResults.put(rank, lottoResults.get(rank) + 1);
        }
    }

    private LottoRank getLottoRank(WiningLottoTicket winingLottoTicket, LottoTicket buyLottoTicket) {
        int countNum = winingLottoTicket.checkLottoNumber(buyLottoTicket);
        boolean isBonusNumber = winingLottoTicket.checkBonusNumber(buyLottoTicket);
        return LottoRank.valueOf(countNum,isBonusNumber);
    }

    public int getTotalPrize() {
        int totalPrize = 0;
        for (LottoRank rank : LottoRank.values()) {
            int money = totalPrizeCalculator(rank, lottoResults.get(rank));
            totalPrize += money;
        }
        return totalPrize;
    }

    private int totalPrizeCalculator(LottoRank rank, Integer integer) {
        return rank.getWinningMoney() * integer;
    }

    public double getProfit() {
        int totalPrice = getTotalPrize();
        return totalPrice / amount;
    }


}
