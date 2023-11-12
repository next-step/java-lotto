package src;

import src.domain.Game;
import src.domain.GameNumber;
import src.domain.Lotto;
import src.domain.Money;
import src.view.InputView;
import src.view.ResultView;

import java.util.HashSet;
import java.util.Set;

public class LottoGameController {

    public static void main(String[] args) {
        Money money = new Money(InputView.inputPurchasePrice());

        Lotto lotto = money.buyLotto();
        printLottoGames(lotto);

        Game winningGame = inputWinningGame();
        lotto.match(winningGame);

        ResultView.printMatchResult(lotto);
    }

    private static void printLottoGames(Lotto lotto) {
        ResultView.printPurchaseLottoGameCount(lotto.gameCount());
        ResultView.printLottoGames(lotto.games());
    }

    private static Game inputWinningGame() {
        Set<GameNumber> winningNumbers = new HashSet<>(6);

        for (Integer number: InputView.inputWinningNumbers()) {
            winningNumbers.add(GameNumber.of(number));
        }

        return Game.byGameNumbers(winningNumbers);
    }
}
