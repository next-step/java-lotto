package lotto.domain;

import java.util.List;

public class LottoTicket {
    private final List<LottoNumber> lottoTicket;

    public LottoTicket(List<LottoNumber> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public List<LottoNumber> getLottoTicket() {
        return lottoTicket;
    }

    public WinningNumber getWinningLotto() {
        return new WinningNumber(lottoTicket);
    }

    public int numberCount() {
        return lottoTicket.size();
    }

    public boolean contains(LottoNumber winningNumber) {
        return lottoTicket.contains(winningNumber);
    }
}
