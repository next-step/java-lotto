package lotto.domain;

public class WinningLotto {
    private final LottoTicket lottoTicket;

    public WinningLotto(LottoTicket lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public int countOfMatch(LottoTicket ticket) {
        return (int) ticket.getLottoNumbers()
                .stream()
                .filter(lottoTicket::containsLottoNumber)
                .count();
    }

    public LottoTicket findWinningLotto() {
        return lottoTicket;
    }
}


