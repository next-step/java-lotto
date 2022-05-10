package lotto.domain;

public class Lotto {
    private final WinningLotto winningLotto;

    public Lotto(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public RankGroup compareLotto(LottoTicketGroup lottoTicketGroup) {
        return lottoTicketGroup.getLottoRankings(winningLotto);
    }
}
