package camp.nextstep.edu.lotto;

import camp.nextstep.edu.lotto.domain.Lotteries;
import camp.nextstep.edu.lotto.domain.LotteryService;
import camp.nextstep.edu.lotto.domain.RewardType;
import camp.nextstep.edu.lotto.domain.SimpleLotteryService;
import camp.nextstep.edu.lotto.view.ConsoleInputView;
import camp.nextstep.edu.lotto.view.ConsoleResultView;
import camp.nextstep.edu.lotto.view.InputView;
import camp.nextstep.edu.lotto.view.ResultView;

import java.util.Map;
import java.util.Set;

public class LotteryApplication {
    private final LotteryService simpleLotteryService;
    private final InputView inputView;
    private final ResultView resultView;

    public LotteryApplication(LotteryService simpleLotteryService,
                              InputView inputView,
                              ResultView resultView) {
        this.simpleLotteryService = simpleLotteryService;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public static void main(String[] args) {
        final LotteryService simpleLotteryService = new SimpleLotteryService();
        final InputView consoleInputView = new ConsoleInputView();
        final ResultView consoleResultView = new ConsoleResultView();

        final LotteryApplication lotteryApplication = new LotteryApplication(
                simpleLotteryService,
                consoleInputView,
                consoleResultView
        );

        try {
            lotteryApplication.run();
        } catch (Exception ex) {
            System.out.println("Exception occurred while running LotteryApplication. message: " + ex.getMessage());
        }
    }

    public void run() {
        final int investment = inputView.inputInvestment();
        final Lotteries purchasedLotteries = simpleLotteryService.purchase(investment);
        resultView.printPurchasedLotteries(purchasedLotteries);

        final Set<Integer> winningNumbers = inputView.inputWinningNumbers();
        final Map<RewardType, Integer> rewardMap = simpleLotteryService.getResult(purchasedLotteries, winningNumbers);
        final double earningsRate = simpleLotteryService.calculateEarningsRate(investment, rewardMap);
        resultView.printResults(rewardMap, earningsRate);
    }
}
