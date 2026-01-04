package lotto;


import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoMachine machine;

    public LottoController(InputView inputView, ResultView resultView, LottoMachine machine) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.machine = machine;
    }

    public void run() {
        Money money = readMoney();
        int manualCount = readManualCount(money);
        List<Lotto> manualLottos = readManualLottos(manualCount);

        Lottos issued = issueAll(money, manualCount, manualLottos);
        resultView.printPurchaseSummary(manualCount, money.ticketCount() - manualCount);
        resultView.printLottos(issued);

        WinningNumbers winningNumbers = readWinningNumbers();
        WinningStatistics stats = winningNumbers.match(issued);

        resultView.printStatistics(stats);
        resultView.printProfitRate(stats.profitRate(money));
    }

    private Money readMoney() {
        while (true) {
            try {
                return Money.of(inputView.readPurchaseAmount());
            } catch (IllegalArgumentException e) {
                resultView.printError(e.getMessage());
            }
        }
    }

        Lottos tickets = lottoMachine.issue(money);
        resultView.printLottos(tickets);

        Lotto winning = new Lotto(inputView.readWinningNumbers());
        WinningNumbers winningNumbers = new WinningNumbers(winning, inputView.readBonusNumber());

        WinningStatistics stats = winningNumbers.match(tickets);
        resultView.printStatistics(stats, money);
    }
}
