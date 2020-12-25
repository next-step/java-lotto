package com.ssabae.nextstep.lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-19
 */
public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    private final int manualTicketCount;

    public static LottoTickets of(List<LottoTicket> lottoTickets, int manualTicketCount) {

        return new LottoTickets(lottoTickets, manualTicketCount);
    }

    private LottoTickets(List<LottoTicket> lottoTickets, int manualTicketCount) {
        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
        this.manualTicketCount = manualTicketCount;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public int getManualTicketCount() {
        return manualTicketCount;
    }
}
