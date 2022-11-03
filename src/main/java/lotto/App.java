package lotto;

import lotto.domain.*;
import lotto.view.AutoRetryInputView;
import lotto.view.ResultView;

public class App {

    public static void main(String[] args) {
        Positive price = AutoRetryInputView.inputPrice();
        Positive lottoCount = price.divide(Lotto.PRICE);

        Positive selfCount = AutoRetryInputView.inputSelfCount(lottoCount);
        Lottos selfLottos = AutoRetryInputView.inputSelfLottos(selfCount);

        Game game = new Game(lottoCount, selfLottos, new RandomLottoPublisher());
        ResultView.printLottoList(selfLottos.size(), game.getLottos());

        Lotto winNumbers = AutoRetryInputView.inputWinLotto();
        LottoNumber bonusNumber = AutoRetryInputView.inputBonusNumber(winNumbers);
        LottoResult result = game.play(winNumbers, bonusNumber);

        ResultView.printResult(result);
        ResultView.printProfit(price, result);
    }
}
