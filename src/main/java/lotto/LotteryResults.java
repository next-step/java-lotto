package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LotteryResults {

    private Map<LottoRank, Integer> lottoResultMap;

    private double amount;


    public LotteryResults(WiningLottoTicket winingLottoTicket, List<LottoTicket> buyLottoTickets, int amount) {
        this.amount = amount;
        this.lottoResultMap = new HashMap<>();
        initLottoResultMap();
        saveLotteryResult(winingLottoTicket, buyLottoTickets);
    }

    public Map<LottoRank, Integer> getLottoResultMap() {
        return lottoResultMap;
    }

    private void initLottoResultMap() {
        for (LottoRank rank : LottoRank.values()) {
            lottoResultMap.put(rank, 0);
        }

    }

    private void saveLotteryResult(WiningLottoTicket winingLottoTicket, List<LottoTicket> buyLottoTickets) {
        for (LottoTicket buyLottoTicket : buyLottoTickets) {
            int countNum = winingLottoTicket.checkLottoNumber(buyLottoTicket);
            LottoRank rank = LottoRank.valueOf(countNum);
            lottoResultMap.put(rank, lottoResultMap.get(rank) + 1);
        }
    }

    private int getTotalPrize() {
        int totalPrize = 0;

        for (LottoRank rank : LottoRank.values()) {
            int money = totalPrizeCalculator(rank, lottoResultMap.get(rank));
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
