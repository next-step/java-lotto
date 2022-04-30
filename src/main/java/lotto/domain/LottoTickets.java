package lotto.domain;

import java.util.LinkedList;
import java.util.List;

public class LottoTickets {

    private  List<LottoTicket> lottoTickets = new LinkedList<>();

    public LottoTickets() {
    }

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public void add() {
        lottoTickets.add(LottoTicket.create());
    }

    public int count() {
        return lottoTickets.size();
    }

    public List<LottoResult> findLottoResult(List<Integer> winLottoNumber, int bonusNumber) {
        List<LottoResult> lottoResults = new LinkedList<>();

        for (LottoTicket lottoTicket : lottoTickets) {
            lottoResults.add(lottoTicket.checkLottery(winLottoNumber, bonusNumber));
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
