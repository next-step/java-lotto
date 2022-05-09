package lotto.domain;

public class Lotto {
    private final LottoTicket winningLotto;
    private final LottoNumber bonusNumber;

    public Lotto(LottoTicket winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public RankGroup compareLotto(LottoTicketGroup lottoTicketGroup, LottoNumber bonusNumber) {
        return lottoTicketGroup.getLottoRankings(winningLotto, bonusNumber);
    }
}
