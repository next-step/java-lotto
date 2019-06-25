package camp.nextstep.edu.lotto;

import camp.nextstep.edu.lotto.domain.Lotteries;
import camp.nextstep.edu.lotto.domain.LotteryServiceImpl;
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
    private final LotteryServiceImpl lotteryServiceImpl;
    private final InputView inputView;
    private final ResultView resultView;

    public LotteryApplication(LotteryServiceImpl lotteryServiceImpl,
                              InputView inputView,
                              ResultView resultView) {
        this.lotteryServiceImpl = lotteryServiceImpl;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public static void main(String[] args) {
        final LotteryServiceImpl lotteryServiceImpl = new LotteryServiceImpl();
        final InputView consoleInputView = new ConsoleInputView();
        final ResultView consoleResultView = new ConsoleResultView();

        final LotteryApplication lotteryApplication = new LotteryApplication(
                lotteryServiceImpl,
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
        final Lotteries purchasedLotteries = lotteryServiceImpl.purchase(investment);
        resultView.printPurchasedLotteries(purchasedLotteries);

        final Set<Integer> winningNumbers = inputView.inputWinningNumbers();
        final Map<RewardType, Integer> rewardMap = lotteryServiceImpl.getResult(purchasedLotteries, winningNumbers);
        final double earningsRate = lotteryServiceImpl.calculateEarningsRate(investment, rewardMap);
        resultView.printResults(rewardMap, earningsRate);
    }
}
