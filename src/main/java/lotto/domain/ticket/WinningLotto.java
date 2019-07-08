package lotto.domain.ticket;

import lotto.common.PositiveNumber;

public class WinningLotto {
    private LottoNumbers winningTicket;
    private LottoNumber bounsNumber;

    private WinningLotto(LottoNumbers winningTicket, LottoNumber bounsNumber) {
        this.winningTicket = winningTicket;
        this.bounsNumber = bounsNumber;
    }

    public static WinningLotto of(LottoNumbers winningTicket, LottoNumber bounsNumber){
        return new WinningLotto(winningTicket, bounsNumber);
    }

    public PositiveNumber getMatchCount(LottoTicket lottoTicket) {
        return PositiveNumber.of(lottoTicket.getLottoNumbers().stream()
                .filter(winningTicket::existNumber)
                .count());
    }

    public boolean matchBonusNumber(LottoTicket lottoTicket) {
        return lottoTicket.existBounsNumber(bounsNumber);
    }
}
