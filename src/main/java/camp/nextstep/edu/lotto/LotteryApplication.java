package camp.nextstep.edu.lotto;

import camp.nextstep.edu.lotto.domain.*;
import camp.nextstep.edu.lotto.view.InputView;
import camp.nextstep.edu.lotto.view.ResultView;
import camp.nextstep.edu.lotto.view.console.ConsoleInputView;
import camp.nextstep.edu.lotto.view.console.ConsoleResultView;
import camp.nextstep.edu.lotto.view.console.formatter.Formatter;
import camp.nextstep.edu.lotto.view.console.formatter.LotteriesFormatter;
import camp.nextstep.edu.lotto.view.console.formatter.LotteryFormatter;
import camp.nextstep.edu.lotto.view.console.formatter.LotteryNumberFormatter;

import java.util.List;
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
        final Formatter<LotteryNumber> lotteryNumberFormatter = new LotteryNumberFormatter();
        final Formatter<Lottery> lotteryFormatter = new LotteryFormatter(lotteryNumberFormatter);
        final Formatter<Lotteries> lotteriesFormatter = new LotteriesFormatter(lotteryFormatter);

        final LotteryService simpleLotteryService = new SimpleLotteryService();
        final InputView consoleInputView = new ConsoleInputView();
        final ResultView consoleResultView = new ConsoleResultView(lotteriesFormatter);

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
        final int numberOfCustomizedLotteries = inputView.inputNumberOfCustomizedLotteries();
        simpleLotteryService.validate(investment, numberOfCustomizedLotteries);

        final List<List<Integer>> numbers = inputView.inputNumbersForCustomizedLotteries(numberOfCustomizedLotteries);

        final Lotteries purchasedLotteries = simpleLotteryService.purchase(investment, numbers);
        final int numberOfRandomizedLotteries = purchasedLotteries.size() - numberOfCustomizedLotteries;
        resultView.printPurchasedLotteries(purchasedLotteries, numberOfCustomizedLotteries, numberOfRandomizedLotteries);

        final Set<Integer> winningNumbers = inputView.inputWinningNumbers();
        final Integer bonusNumber = inputView.inputBonusNumber();
        final LotteriesReward lotteriesReward = simpleLotteryService.getResult(purchasedLotteries, winningNumbers, bonusNumber);
        final double earningsRate = simpleLotteryService.calculateEarningsRate(investment, lotteriesReward);
        resultView.printResults(lotteriesReward, earningsRate);
    }
}
