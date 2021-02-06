package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private final List<LottoTicket> lottoTickets;
    private LotteryNumber lotteryNumber;

    public LottoService() {
        lottoTickets = new ArrayList<>();
    }

    public LottoService(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public void buyLottoTicketsAuto(int numberOfTickets) {
        for (int i = 0; i < numberOfTickets; ++i) {
            lottoTickets.add(new LottoTicket());
        }
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }


    public void recordLotteryNumber(LotteryNumber lotteryNumber) {
        this.lotteryNumber = lotteryNumber;
    }

    public int calculateResult(Map<Rank, Integer> lottoRankingStatus) {
        int profit = 0;
        for (LottoTicket lottoTicket : lottoTickets) {
            Rank currentRank = lottoTicket.calculateRank(lotteryNumber);
            lottoRankingStatus.put(currentRank, lottoRankingStatus.get(currentRank) + 1);
            profit += currentRank.getReward();
        }
        return profit;
    }

    public double getInterestRate(int profit) {
        int totalLottoPrice = LottoTicket.PRICE * lottoTickets.size();
        return (double) profit / totalLottoPrice;
    }
}
