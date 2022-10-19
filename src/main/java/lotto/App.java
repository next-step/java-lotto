package lotto;

import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        int price = InputView.inputPrice();

        Game game = new Game(price / Lotto.PRICE);
        ResultView.printLottoList(game.getLottoList());

        List<Integer> winNumbers = InputView.inputWinNumbers();
        Map<Integer, Integer> result = game.play(new Lotto(winNumbers));
        ResultView.printResult(price, result);
    }
}
