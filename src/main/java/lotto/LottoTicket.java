package lotto;

import java.util.List;

public class LottoTicket {
    private List<LottoNumber> lottoTicket;

    public LottoTicket(List<LottoNumber> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public int lottoTicketSize() {
        return lottoTicket.size();
    }

    public boolean compareWinningNumber(LottoNumber winningNumber) {
        return lottoTicket.contains(winningNumber);
    }

    public boolean compareBonusBall(LottoNumber bonusBall) {
        return lottoTicket.contains(bonusBall);
    }

    @Override
    public String toString() {
        return lottoTicket + "";
    }
}
