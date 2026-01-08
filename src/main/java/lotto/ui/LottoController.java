package lotto.ui;


import java.util.List;
import lotto.domain.Lotto;
import lotto.application.LottoMachine;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningStatistics;

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

        Lottos issued = machine.issue(money, manualLottos);

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

    private int readManualCount(Money money) {
        while (true) {
            try {
                int manualCount = inputView.readManualCount();
                if (manualCount < 0 || manualCount > money.ticketCount()) {
                    throw new IllegalArgumentException("수동 로또 개수는 0 이상이며 전체 구매 개수 이하여야 합니다.");
                }
                return manualCount;
            } catch (IllegalArgumentException e) {
                resultView.printError(e.getMessage());
            }
        }
    }

    private List<Lotto> readManualLottos(int manualCount) {
        while (true) {
            try {
                return inputView.readManualLottos(manualCount);
            } catch (IllegalArgumentException e) {
                resultView.printError(e.getMessage());
            }
        }
    }

    private WinningNumbers readWinningNumbers() {
        while (true) {
            try {
                Lotto winning = new Lotto(inputView.readWinningNumbers());
                int bonus = inputView.readBonusNumber();
                return new WinningNumbers(winning, bonus);
            } catch (IllegalArgumentException e) {
                resultView.printError(e.getMessage());
            }
        }
    }
}
