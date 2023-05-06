package lotto.domain;

public class LottoGame {

    private final LottoTickets lottoTickets;
    private final WinningLotto winningLotto;

    public LottoGame(LottoTickets lottoTickets, String winningNumbersString) {
        this(lottoTickets, winningNumbersString, null);
    }

    public LottoGame(LottoTickets lottoTickets, String winningNumbersString, Integer bonusNumber) {
        this.lottoTickets = lottoTickets;
        this.winningLotto = WinningLottoFactory.create(winningNumbersString, bonusNumber);
    }

    public WinningStatistics calculateWinningStatistics() {
        return lottoTickets.calculateLottoStatistics(winningLotto);
    }
}
