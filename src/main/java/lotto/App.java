package lotto;

import lotto.domain.Game;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.RandomLottoPublisher;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {
        int price = InputView.inputPrice();

        Game game = new Game(price / Lotto.PRICE, new RandomLottoPublisher());
        ResultView.printLottoList(game.getLottos());

        List<Integer> winNumbers = InputView.inputWinNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        Map<Prize, Integer> result = game.play(new Lotto(winNumbers), bonusNumber);
        ResultView.printResult(result);
        ResultView.printProfit(price, result);
    }
}
