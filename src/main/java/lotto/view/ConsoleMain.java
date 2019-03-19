package lotto.view;

import lotto.Lotto;
import lotto.LottoGame;
import lotto.LottoResult;

import java.util.List;

public class ConsoleMain {
    public static void main(String[] args) {
        int money = InputView.input();
        OutputView.issueLottoTickets(money);

        LottoGame lottoGame = new LottoGame();
        List<Lotto> lottos = lottoGame.buy(money);
        OutputView.printLottoNumbers(lottos);

        Lotto luckyNumbers = InputView.inputLuckyNumbers();
        LottoResult lottoResult = new LottoResult();
        int[] result = lottoGame.checkLuckyCount(lottoResult, luckyNumbers);
        OutputView.printMatchCount(result);

        double rate = lottoResult.calculateRate(money);
        OutputView.printRate(rate);
    }
}
