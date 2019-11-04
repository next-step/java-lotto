package lotto;

import calculator.OutputView;
import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.OutPutView;

public class LottoMain {
    public static void main(String[] args) {
        int money = InputView.inputMoney();

        LottoGame lottoGame = new LottoGame(money);
        OutPutView.printGameCount(lottoGame.lottoSize());
        OutputView.printLottos(lottoGame.getLottos());

        String winningNumbers = InputView.inputWinningNumbers();
        lottoGame.winningLotto(winningNumbers);
    }
}
