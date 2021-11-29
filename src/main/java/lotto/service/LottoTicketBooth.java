package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketFactory;
import lotto.domain.LottoTickets;
import lotto.domain.Money;

public class LottoTicketBooth implements LottoTicketsGenerator {

    private static class LottoTicketBoothHolder {

        private static final LottoTicketBooth LOTTO_TICKET_BOOTH = new LottoTicketBooth();
    }

    private LottoTicketBooth() {
    }

    public static LottoTicketBooth getInstance() {
        return LottoTicketBoothHolder.LOTTO_TICKET_BOOTH;
    }

    @Override
    public LottoTickets generate(Money money) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < money.getAutoCount(); i++) {
            lottoTickets.add(LottoTicket.from(LottoTicketFactory
                .autoLotto()
                .createLottoNumber()));
        }
        return new LottoTickets(lottoTickets);
    }

    @Override
    public LottoTickets generate(List<String> manualLottoNumbers) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (String manualLottoNumber : manualLottoNumbers) {
            lottoTickets.add(LottoTicket.from(LottoTicketFactory
                .manualLotto(manualLottoNumber)
                .createLottoNumber()));
        }
        return new LottoTickets(lottoTickets);
    }

}
