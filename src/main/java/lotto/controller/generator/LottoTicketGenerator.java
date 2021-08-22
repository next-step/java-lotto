package lotto.controller.generator;

import java.util.List;

import lotto.domain.LottoTicket;

public interface LottoTicketGenerator {
    static List<LottoTicket> createLottoTickets(LottoTicketGenerator lottoTicketGenerator, int lottoCount) {
        return lottoTicketGenerator.createLottoTickets(lottoCount);
    }

    List<LottoTicket> createLottoTickets(int lottoTicketCount);
}
