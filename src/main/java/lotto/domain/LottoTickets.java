package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LottoTickets implements Iterable<LottoTicket> {

    private final List<LottoTicket> lottoTickets;
    private final LottoResult result;

    public LottoTickets() {
        this.lottoTickets = new ArrayList<>();
        this.result = new LottoResult();
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
            result.addLottoRank(lottoRank);
        }
    }

    public LottoResult getResult() {
        return result;
    }

    public double getRate(int money) {
        return result.getRate(money);
    }

    @Override
    public Iterator<LottoTicket> iterator() {
        return lottoTickets.iterator();
    }
}
