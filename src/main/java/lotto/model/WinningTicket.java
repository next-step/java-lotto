package lotto.model;

import java.util.Set;

public class WinningTicket {

    private final LottoTicket lottoTicket;

    public WinningTicket(Set<LottoNumber> lottoNumbers) {
        this.lottoTicket = new LottoTicket(lottoNumbers);
    }

    public Rank getRank(LottoTicket lottoTicket) {
        int count = this.lottoTicket.countMatches(lottoTicket);
        return Rank.valueOf(count);
    }

}
