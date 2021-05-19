package lotto;

import lotto.domain.PositiveInteger;
import lotto.domain.Game;
import lotto.domain.rank.LottoRanks;
import lotto.domain.LottoWon;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        PositiveInteger money = inputView.money();

        Game game = Game.createByMoney(money);
        OutputView outputView = new OutputView(game);

        outputView.countOfTicket();
        outputView.ticketNumbers();

        LottoWon lottoWon = inputView.wonNumbers();
        LottoRanks match = game.match(lottoWon);

        outputView.printRanks(match);
        outputView.printYields(match);
    }
}
