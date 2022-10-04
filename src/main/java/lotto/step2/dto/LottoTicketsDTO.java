package lotto.step2.dto;

import lotto.step2.domain.LottoTicket;

import java.util.List;

public class LottoTicketsDTO {
    private final List<LottoTicket> lottoTickets;
    
    public LottoTicketsDTO(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }
    
    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
