package lotto;

import lotto.game.Rank;
import lotto.game.Round;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.EnumMap;
import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int amount = InputView.inputAmount();
        Round round = LottoStore.buy(amount);

        OutputView.printGameCount(round.gameCount());
        OutputView.printGames(round.getGames());

        List<Integer> winNumbers = InputView.inputWinNumbers();
        EnumMap<Rank, Integer> result = round.getResult(winNumbers);
        long totalAward = round.totalAward(winNumbers);

        OutputView.printResult(amount, totalAward, result);
    }
}
