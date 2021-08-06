package lotto.domain;

import java.util.List;

public class LottoWallet {

    private final List<LottoTicket> lottoTicketList;

    public LottoWallet(List<LottoTicket> lottoTicketList) {
        this.lottoTicketList = lottoTicketList;
    }

    public int size() {
        return lottoTicketList.size();
    }
}