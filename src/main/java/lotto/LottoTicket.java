package lotto;

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

    @Override
    public String toString() {
        return "LottoTicket{" + lottoTicket + "}\n";
    }
}
