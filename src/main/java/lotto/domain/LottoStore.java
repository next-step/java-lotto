package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoStore {

    private LottoStore() {}

    public static List<LottoTicket> sellAutoLottoTicket(LottoMoney lottoMoney) {
        final List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoMoney.getNumberOfLottoByMoneyPaid(); i++) {
            final LottoTicket lottoTicket = new AutoLottoTicket();
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

}
