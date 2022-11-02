package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class App {

    public static void main(String[] args) {
        int price = InputView.inputPrice();

        int selfCount = InputView.inputSelfCount();
        List<Lotto> selfLottos = InputView.inputSelfLottos(selfCount);

        Game game = new Game(price / Lotto.PRICE, new RandomLottoPublisher());
        ResultView.printLottoList(selfLottos, game.getLottos());

        Lotto winNumbers = InputView.inputWinLotto();
        int bonusNumber = InputView.inputBonusNumber(winNumbers);
        LottoResult result = game.play(winNumbers, bonusNumber);
        ResultView.printResult(result);
        ResultView.printProfit(price, result);
    }
}
