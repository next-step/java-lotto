package lotto;

import lotto.game.Round;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMain {
    public static void main(String[] args) {
        int amount = InputView.inputAmount();
        Round round = LottoStore.buy(amount);

        OutputView.printGameCount(round.gameCount());
        OutputView.printGames(round.getGames());
    }
}
