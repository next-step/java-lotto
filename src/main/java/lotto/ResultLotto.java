package lotto;

public class ResultLotto {

    private final LottoTicket winningTicket;

    public ResultLotto(LottoTicket winningTicket) {
        this.winningTicket = winningTicket;
    }

    public Award award(LottoTicket lottoTicket) {
        return Award.of(this.winningTicket.matchOfNumberCount(lottoTicket));
    }

}
