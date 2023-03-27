package lottoGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String... arg) {
        LottoGame lottoGame = new LottoGame();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        // 구입금액 입력
        int inputMoney = inputView.getInputMoney();

        // 수동으로 구매할 로또 수 입력
        int inputManualLottoCount = inputView.getInputManualLottoCount(inputMoney);

        // 수동으로 구매할 번호 입력
        List<Lotto> manualLottos = inputView.getInputManualLottoNumber(inputManualLottoCount);

        // 로또 구매
        lottoGame.buyLotto(inputMoney, manualLottos);

        // 구매 결과 프린트
        resultView.printTicket(lottoGame);

        // 지난 주 당첨 번호 입력
        Set<Integer> winningNumbers = inputView.getWinningNumbers();

        lottoGame.inputWinningNumbers(winningNumbers);

        // 보너스 볼 입력
        int bonusNumber = inputView.getBonusNumber();

        lottoGame.inputBonusNumber(bonusNumber);

        //
        lottoGame.run();

        resultView.showResult(lottoGame);
    }
}
