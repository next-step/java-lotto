package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private Map<LottoRank, Integer> result;

    public LottoResult() {
        this.result = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            result.put(lottoRank, 0);
        }
    }

    public void calculateRank(List<LottoTicket> lottoTickets, WinnerNumber winnerNumber) {
        for (LottoTicket lottoTicket : lottoTickets) {
            int matchCount = winnerNumber.matchCount(lottoTicket.getLottoNumbers());
            LottoRank lottoRank = LottoRank.getLottoRank(matchCount);
            result.put(lottoRank, result.getOrDefault(lottoRank, 0) + 1);
        }
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public double getRate(int money) {
        int total = 0;
        for (LottoRank lottoRank : result.keySet()) {
            total += lottoRank.getReward() * result.get(lottoRank);
        }

        return (double)total / money;

    }
}
