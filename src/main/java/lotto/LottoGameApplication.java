package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoGenerator;
import lotto.view.InputVIew;
import lotto.view.OutputView;

public class LottoGameApplication {

    public static void main(String[] args) {

        int money = InputVIew.scanMoney();
        String winningNumber = InputVIew.scanWinningNumber();

        LottoGame lottoGame = new LottoGame(money, new LottoGenerator(), winningNumber);

        OutputView.PrintLottos(lottoGame.getLottos());
        OutputView.printResult(lottoGame.getLottoResult());
    }
}
