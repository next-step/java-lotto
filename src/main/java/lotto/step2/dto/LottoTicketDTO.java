package lotto.step2.dto;

import lotto.step2.domain.LottoNumber;

import java.util.List;

public class LottoTicketDTO {
    private final List<LottoNumber> lottoTicket;
    
    public LottoTicketDTO(List<LottoNumber> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }
    
    public List<LottoNumber> getLottoTicket() {
        return lottoTicket;
    }
}
