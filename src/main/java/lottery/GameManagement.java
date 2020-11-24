package lottery;

import lottery.domain.Picker;
import lottery.domain.ShufflePicker;
import lottery.domain.Lottery;
import lottery.view.InputView;
import lottery.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameManagement {
    private final List<Lottery> lotteries;

    public GameManagement(int numberGames) {
        final Picker picker = new ShufflePicker();
        this.lotteries = IntStream.range(0, numberGames)
                .mapToObj(i -> new Lottery(picker))
                .collect(Collectors.toUnmodifiableList());
    }

    public Map<Integer, Long> getMatches(Lottery winningNumber) {
        return lotteries.stream()
                .map(winningNumber::countMatched)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        int nGames = inputView.getMoneyToBuy() / 1000;
        GameManagement game = new GameManagement(nGames);
        outputView.showLotteries(game.lotteries);

        Map<Integer, Long> winnings = game.getMatches(inputView.getWinningNumber());
        outputView.showWinnings(nGames * 1000, winnings);
    }
}
