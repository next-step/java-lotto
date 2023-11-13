package src;

import src.domain.Game;
import src.domain.GameNumber;
import src.domain.LottoV1;
import src.domain.Money;
import src.view.InputView;
import src.view.ResultView;

import java.util.HashSet;
import java.util.Set;

public class LottoGameController {

    public static void main(String[] args) {
        Money money = new Money(InputView.inputPurchasePrice());

        LottoV1 lottoV1 = money.buyLotto();
        printLottoGames(lottoV1);

        Game winningGame = inputWinningGame();
        lottoV1.match(winningGame);

        ResultView.printMatchResult(lottoV1);
    }

    private static void printLottoGames(LottoV1 lottoV1) {
        ResultView.printPurchaseLottoGameCount(lottoV1.gameCount());
        ResultView.printLottoGames(lottoV1.games());
    }

    private static Game inputWinningGame() {
        Set<GameNumber> winningNumbers = new HashSet<>(6);

        for (Integer number: InputView.inputWinningNumbers()) {
            winningNumbers.add(GameNumber.of(number));
        }

        return Game.byGameNumbers(winningNumbers);
    }
}
