package lotto.domain;

public class Lotto {
    private final LottoTicket winningLotto;

    public Lotto(LottoTicket winningLotto) {
        this.winningLotto = winningLotto;
    }

    public RankGroup compareLotto(LottoTicketGroup lottoTicketGroup) {
        return lottoTicketGroup.getLottoRankings(winningLotto);
    }
}
