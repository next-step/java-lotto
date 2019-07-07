package lotto.domain.ticket;

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

    public long getMatchCount(LottoTicket lottoTicket) {
        return lottoTicket.getLottoNumbers().stream()
                .filter(winningTicket::existNumber)
                .count();
    }

    public boolean matchBonusNumber(LottoTicket lottoTicket) {
        return lottoTicket.existBounsNumber(bounsNumber);
    }
}
