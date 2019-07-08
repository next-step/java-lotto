package lotto.domain.ticket;

import java.util.List;

public class LottoTicket {
    public static final long PRICE = 1000L;

    private LottoNumbers lottoNumbers;
    private LottoTicketType lottoTicketType;

    private LottoTicket(LottoNumbers lottoNumbers, LottoTicketType lottoTicketType) {
        this.lottoNumbers = lottoNumbers;
        this.lottoTicketType = lottoTicketType;
    }

    public static LottoTicket of(LottoNumbers lottoNumbers) {
        return new LottoTicket(lottoNumbers, LottoTicketType.AUTO);
    }

    public static LottoTicket ofManual(LottoNumbers lottoNumbers) {
        return new LottoTicket(lottoNumbers, LottoTicketType.MANUAL);
    }

    public String getLottoTicketNumbers() {
        return lottoNumbers.getLottoTicketNumbers();
    }

    public boolean existBounsNumber(LottoNumber bonusNumber) {
        return lottoNumbers.existNumber(bonusNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers.findAll();
    }

    public boolean isAutoTicket() {
        return lottoTicketType == LottoTicketType.AUTO;
    }

    public boolean isManualTicket() {
        return lottoTicketType == LottoTicketType.MANUAL;
    }
}
