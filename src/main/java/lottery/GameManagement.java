package lottery;

import lottery.domain.Lotteries;
import lottery.domain.WinningNumber;
import lottery.domain.WinningType;
import lottery.domain.strategy.ShufflePicker;
import lottery.domain.strategy.StaticPicker;
import lottery.view.InputView;
import lottery.view.OutputView;

import java.util.List;
import java.util.Map;

public class GameManagement {
    private static final int MONEY_PER_LOTTERY = 1000;

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int nGames = inputView.getMoneyToBuy() / MONEY_PER_LOTTERY;
        List<String> prePickedNumbers = inputView.getManualPurchases();

        Lotteries manualPicked = Lotteries.repeat(prePickedNumbers.size(), new StaticPicker(prePickedNumbers));
        Lotteries autoPicked = Lotteries.repeat(nGames - prePickedNumbers.size(), new ShufflePicker());
        outputView.showLotteries(manualPicked, autoPicked);

        WinningNumber winningNumber = WinningNumber.from(new StaticPicker(inputView.getWinningNumber()));
        Map<WinningType, Long> winnings = manualPicked.getMatches(winningNumber);
        autoPicked.getMatches(winningNumber).forEach((k, v) -> winnings.merge(k, v, Long::sum));
        outputView.showWinnings(nGames * MONEY_PER_LOTTERY, winnings);
    }
}
