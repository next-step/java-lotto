package lotto.domain;

public class LottoGame {

    private final LottoTickets lottoTickets;
    private final WinningLotto winningLotto;

    public LottoGame(LottoTickets lottoTickets, String winningNumbersString) {
        this.lottoTickets = lottoTickets;
        this.winningLotto = WinningLottoFactory.create(winningNumbersString);
    }

    public WinningStatistics calculateWinningStatistics() {
        return lottoTickets.calculateLottoStatistics(winningLotto);
    }
}
