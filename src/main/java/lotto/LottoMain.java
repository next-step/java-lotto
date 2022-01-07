package lotto;

import java.util.Set;
import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        int totalCount = InputView.inputPrice();
        int manualCount = InputView.inputManualCount();
        LottoGame lottoGame = new LottoGame(totalCount, manualCount);

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        while (manualCount > 0) {
            Set<Integer> manualLottoNumber = InputView.inputManualLottoNumber();
            lottoGame.addManualLotto(manualLottoNumber);
            manualCount--;
        }
        lottoGame.addRandomLotto();
        ResultView.printLottoNumbers(lottoGame);

        Set<Integer> winningNumbers = InputView.inputWinningNumber();
        int bonusBall = InputView.inputBonusBall();
        ResultView.printLottoGameResult(lottoGame.draw(winningNumbers, bonusBall));
    }
}
