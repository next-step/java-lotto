package lotto;

import lotto.model.Lotto;
import lotto.view.InputView;
import lotto.view.QuestionType;
import lotto.view.ResultView;

import java.util.List;

public class LottoGameConsole {

    public static void main(String args[]) {
        int money = InputView.inputInteger(QuestionType.MONEY_FOR_BUY.getQuestion());
        LottoGame lottoGame = new LottoGame();
        List<Lotto> lottos = lottoGame.buy(money);

        ResultView.printBoughtHistory(lottos);
    }
}
