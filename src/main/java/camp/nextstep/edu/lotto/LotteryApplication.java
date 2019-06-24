package camp.nextstep.edu.lotto;

import camp.nextstep.edu.lotto.controller.LotteryController;
import camp.nextstep.edu.lotto.domain.Lottery;
import camp.nextstep.edu.lotto.domain.NaturalNumber;
import camp.nextstep.edu.lotto.domain.RewardType;
import camp.nextstep.edu.lotto.view.ConsoleInputView;
import camp.nextstep.edu.lotto.view.ConsoleResultView;
import camp.nextstep.edu.lotto.view.InputView;
import camp.nextstep.edu.lotto.view.ResultView;

import java.util.EnumMap;
import java.util.List;
import java.util.Set;

public class LotteryApplication {
    private final LotteryController lotteryController;
    private final InputView inputView;
    private final ResultView resultView;

    public LotteryApplication(LotteryController lotteryController,
                              InputView inputView,
                              ResultView resultView) {
        this.lotteryController = lotteryController;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public static void main(String[] args) {
        final LotteryController lotteryController = new LotteryController();
        final InputView consoleInputView = new ConsoleInputView();
        final ResultView consoleResultView = new ConsoleResultView();

        final LotteryApplication lotteryApplication = new LotteryApplication(
                lotteryController,
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
        final List<Lottery> purchasedLotteries = lotteryController.purchase(investment);
        resultView.printPurchasedLotteries(purchasedLotteries);

        final Set<Integer> winningNumbers = inputView.inputWinningNumbers();
        final Lottery winningLottery = lotteryController.createWinningLottery(winningNumbers);
        final EnumMap<RewardType, Integer> rewardMap = new EnumMap<>(RewardType.class);
        rewardMap.put(RewardType.SIX_NUMBERS_MATCHED, 0);
        rewardMap.put(RewardType.FIVE_NUMBERS_MATCHED, 0);
        rewardMap.put(RewardType.FOUR_NUMBERS_MATCHED, 0);
        rewardMap.put(RewardType.THREE_NUMBERS_MATCHED, 0);

        purchasedLotteries.stream()
                .map(lottery -> lotteryController.countScore(lottery, winningLottery))
                .forEach(score -> {
                    final RewardType rewardType = RewardType.from(score);
                    final int current = rewardMap.getOrDefault(rewardType, 0);
                    rewardMap.put(rewardType, current + 1);
                });
        final long sumOfRewards = lotteryController.sumAllRewards(rewardMap);
        final double earningsRate = lotteryController.calculateEarningsRate(investment, sumOfRewards);
        resultView.printResults(rewardMap, earningsRate);
    }
}
