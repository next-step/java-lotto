package lotto.domain;

import java.util.LinkedList;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets = new LinkedList<>();

    public void add() {
        lottoTickets.add(LottoTicket.create());
    }

    public int count() {
        return lottoTickets.size();
    }

    public List<LottoResult> findLottoResult(List<Integer> winLottoNumber) {
        List<LottoResult> lottoResults = new LinkedList<>();

        for (LottoTicket lottoTicket : lottoTickets) {
            lottoResults.add(lottoTicket.checkLottery(winLottoNumber));
        }

        return lottoResults;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    @Override
    public String toString() {
        return "LottoTickets{" +
            "lottoTickets=" + lottoTickets +
            '}';
    }
}
