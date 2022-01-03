package lotto;

import java.util.Set;
import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        int number = InputView.inputPrice();
        LottoGame lottoGame = new LottoGame(number);
        ResultView.printLottoNumbers(lottoGame.getLottos());

        Set<Integer> winningNumbers = InputView.inputWinningNumber();
        ResultView.printLottoGameResult(lottoGame.draw(winningNumbers));
    }
}
