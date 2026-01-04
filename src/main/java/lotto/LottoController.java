package lotto;


import java.util.ArrayList;
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

    private int readManualCount(Money money) {
        while (true) {
            try {
                int manualCount = inputView.readManualCount();
                validateManualCount(money, manualCount);
                return manualCount;
            } catch (IllegalArgumentException e) {
                resultView.printError(e.getMessage());
            }
        }
    }

    private void validateManualCount(Money money, int manualCount) {
        if (manualCount < 0) {
            throw new IllegalArgumentException("수동 구매 수는 0 이상이어야 합니다.");
        }
        if (manualCount > money.ticketCount()) {
            throw new IllegalArgumentException("수동 구매 수는 전체 구매 수보다 클 수 없습니다.");
        }
    }

    private List<Lotto> readManualLottos(int manualCount) {
        List<Lotto> manuals = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            manuals.add(readManualLottoOne());
        }
        return manuals;
    }

    private Lotto readManualLottoOne() {
        while (true) {
            try {
                return new Lotto(inputView.readManualNumbers());
            } catch (IllegalArgumentException e) {
                resultView.printError(e.getMessage());
            }
        }
    }

    private Lottos issueAll(Money money, int manualCount, List<Lotto> manualLottos) {
        return machine.issue(money, manualCount, manualLottos);
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
