package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private final int numberOfLottoTicket;

    public LottoStore(LottoMoney lottoMoney) {
        this.numberOfLottoTicket = lottoMoney.getNumberOfLottoByMoneyPaid();
    }

    public List<LottoTicket> sellAutoLottoTicket() {
        final List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < numberOfLottoTicket; i++) {
            final LottoTicket lottoTicket = new AutoLottoTicket(null);
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

}
