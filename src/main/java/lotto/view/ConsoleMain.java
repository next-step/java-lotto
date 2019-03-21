package lotto.view;

import lotto.domain.LuckyLotto;
import lotto.domain.MyLotto;
import lotto.LottoGame;
import lotto.LottoResult;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        int money = InputView.input();
        OutputView.issueLottoTickets(money);

        LottoGame lottoGame = new LottoGame();
        List<MyLotto> myLottos = lottoGame.buy(money);
        OutputView.printLottoNumbers(myLottos);

        LuckyLotto luckyLotto = InputView.inputLuckyNumbers();
        LottoResult lottoResult = lottoGame.checkLuckyCount(luckyLotto);
        OutputView.printResult(lottoResult.checkResult());

        double rate = lottoResult.calculateRate(money);
        OutputView.printRate(rate);
    }
}
