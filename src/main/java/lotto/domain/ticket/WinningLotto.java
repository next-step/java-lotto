package lotto.domain.ticket;

public class WinningLotto {
    private LottoTicket winningTicket;
    private LottoNumber bounsNumber;

    private WinningLotto(LottoTicket winningTicket, LottoNumber bounsNumber) {
        this.winningTicket = winningTicket;
        this.bounsNumber = bounsNumber;
    }

    public static WinningLotto of(LottoTicket winningTicket, LottoNumber bounsNumber){
        return new WinningLotto(winningTicket, bounsNumber);
    }

    public long getMatchCount(LottoTicket lottoTicket) {
        return lottoTicket.findAll().stream()
                .filter(winningTicket::existNumber)
                .count();
    }

    public boolean matchBonusNumber(LottoTicket lottoTicket) {
        return lottoTicket.existNumber(bounsNumber);
    }
}
