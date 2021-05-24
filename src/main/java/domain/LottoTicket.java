package domain;

import java.util.List;

public class LottoTicket {
    private final List<LottoNumber> lottoTicket;

    public LottoTicket(List<LottoNumber> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public int numberCount() {
        return lottoTicket.size();
    }

    public boolean contains(LottoNumber winningNumber) {
        return lottoTicket.contains(winningNumber);
    }

    public List<LottoNumber> getLottoTicket() {
        return lottoTicket;
    }
}
