package camp.nextstep.edu.lotto;

import camp.nextstep.edu.lotto.domain.LotteryService;
import camp.nextstep.edu.lotto.domain.Lottery;
import camp.nextstep.edu.lotto.domain.RewardType;
import camp.nextstep.edu.lotto.view.ConsoleInputView;
import camp.nextstep.edu.lotto.view.ConsoleResultView;
import camp.nextstep.edu.lotto.view.InputView;
import camp.nextstep.edu.lotto.view.ResultView;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class LotteryApplication {
    private final LotteryService lotteryService;
    private final InputView inputView;
    private final ResultView resultView;

    public LotteryApplication(LotteryService lotteryService,
                              InputView inputView,
                              ResultView resultView) {
        this.lotteryService = lotteryService;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public static void main(String[] args) {
        final LotteryService lotteryService = new LotteryService();
        final InputView consoleInputView = new ConsoleInputView();
        final ResultView consoleResultView = new ConsoleResultView();

        final LotteryApplication lotteryApplication = new LotteryApplication(
                lotteryService,
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
        final List<Lottery> purchasedLotteries = lotteryService.purchase(investment);
        resultView.printPurchasedLotteries(purchasedLotteries);

        final Set<Integer> winningNumbers = inputView.inputWinningNumbers();
        final Map<RewardType, Integer> rewardMap = lotteryService.getResult(purchasedLotteries, winningNumbers);
        final double earningsRate = lotteryService.calculateEarningsRate(investment, rewardMap);
        resultView.printResults(rewardMap, earningsRate);
    }
}
