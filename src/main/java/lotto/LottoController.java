package lotto;


import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoMachine lottoMachine;

    public LottoController(InputView inputView, ResultView resultView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoMachine = lottoMachine;
    }

    public void run() {
        Money money = Money.of(inputView.readPurchaseAmount());

        Lottos tickets = lottoMachine.issue(money);
        resultView.printLottos(tickets);

        Lotto winning = new Lotto(inputView.readWinningNumbers());
        WinningNumbers winningNumbers = new WinningNumbers(winning, inputView.readBonusNumber());

        WinningStatistics stats = winningNumbers.match(tickets);
        resultView.printStatistics(stats, money);
    }
}
