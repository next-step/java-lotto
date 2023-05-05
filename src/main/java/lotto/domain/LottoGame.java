package lotto.domain;

public class LottoGame {

    private final LottoTickets lottoTickets;
    private final WinningLotto winningLotto;
    private final BonusNumber bonusNumber;

    public LottoGame(LottoTickets lottoTickets, String winningNumbersString) {
        this(lottoTickets, winningNumbersString, null);
    }

    public LottoGame(LottoTickets lottoTickets, String winningNumbersString, BonusNumber bonusNumber) {
        this.lottoTickets = lottoTickets;
        this.winningLotto = WinningLottoFactory.create(winningNumbersString);
        this.bonusNumber = bonusNumber;
    }

    public WinningStatistics calculateWinningStatistics() {
        return lottoTickets.calculateLottoStatistics(winningLotto, bonusNumber);
    }
}
