package lottery;

import lottery.domain.*;
import lottery.view.InputView;
import lottery.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameManagement {
    private static final int MONEY_PER_LOTTERY = 1000;

    public List<Lottery> purchaseLottery(int numberGames) {
        final Picker picker = new ShufflePicker();
        return IntStream.range(0, numberGames)
                .mapToObj(i -> Lottery.from(picker))
                .collect(Collectors.toUnmodifiableList());
    }

    public Map<Integer, Long> getMatches(List<Lottery> lotteries, WinningNumber winningNumber) {
        return lotteries.stream()
                .map(winningNumber::countMatched)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void main(String[] args) {
        GameManagement game = new GameManagement();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int nGames = inputView.getMoneyToBuy() / MONEY_PER_LOTTERY;
        List<Lottery> lotteries = game.purchaseLottery(nGames);
        outputView.showLotteries(lotteries);

        WinningNumber winningNumber = WinningNumber.from(new StaticPicker(inputView.getWinningNumber()));
        Map<Integer, Long> winnings = game.getMatches(lotteries, winningNumber);
        outputView.showWinnings(nGames * MONEY_PER_LOTTERY, winnings);
    }
}
