package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LottoTickets implements Iterable<LottoTicket> {

    private final List<LottoTicket> lottoTickets;
    private final Map<LottoRank, Integer> result;

    public LottoTickets() {
        this.lottoTickets = new ArrayList<>();
        this.result = new EnumMap<>(LottoRank.class);
        for (LottoRank lottoRank : LottoRank.values()) {
            result.put(lottoRank, 0);
        }
    }

    public void addLottoTicket(LottoTicket lottoTicket) {
        lottoTickets.add(lottoTicket);
    }

    public int size() {
        return lottoTickets.size();
    }

    public void calculate(WinnerNumber winnerNumber) {
        for (LottoTicket lottoTicket : lottoTickets) {
            LottoRank lottoRank = lottoTicket.calculate(winnerNumber);
            result.put(lottoRank, result.getOrDefault(lottoRank, 0) + 1);
        }
    }

    public Map<LottoRank, Integer> getResult() {
        return this.result;
    }

    public double getRate(int money) {
        int total = 0;
        for (LottoRank lottoRank : result.keySet()) {
            total += lottoRank.getReward() * result.get(lottoRank);
        }

        return (double)total / money;

    }

    @Override
    public Iterator<LottoTicket> iterator() {
        return lottoTickets.iterator();
    }
}
