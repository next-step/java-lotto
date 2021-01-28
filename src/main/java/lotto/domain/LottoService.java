package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
    private final List<LottoTicket> lottoTickets;
    private LotteryNumber lotteryNumber;
    private Map<Rank, Integer> lottoResults;
    private int profit;

    public LottoService() {
        lottoTickets = new ArrayList<>();
    }

    public LottoService(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public void buyLottoTickets(int numberOfTickets) {
        for (int i = 0; i < numberOfTickets; ++i) {
            lottoTickets.add(new LottoTicket());
        }
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    private void initLottoResults() {
        lottoResults = new HashMap<>();
        for (Rank rank : Rank.values()) {
            System.out.println(rank);
            lottoResults.put(rank, 0);
        }
    }

    public void recordLotteryNumber(LotteryNumber lotteryNumber) {
        this.lotteryNumber = lotteryNumber;
    }

    public void calculatePrize() {
        initLottoResults();
        for (LottoTicket lottoTicket : lottoTickets) {
            Rank currentRank = lottoTicket.getRank(lotteryNumber);
            lottoResults.put(currentRank, lottoResults.get(currentRank) + 1);
        }
    }
}
