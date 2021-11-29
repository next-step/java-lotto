package lotto.domain;

public class ResultLotto {

    private final LottoTicket winningTicket;
    private final int bonusNumber;

    public ResultLotto(LottoTicket winningTicket, int bonusNumber) {
        this.winningTicket = winningTicket;
        this.bonusNumber = bonusNumber;
    }

    public Award award(LottoTicket lottoTicket) {
        return Award.of(winningTicket.matchOfNumberCount(lottoTicket),
            lottoTicket.matchOfNumber(bonusNumber));
    }

}
