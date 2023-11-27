package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {

    private final static InputView inputView = new InputView();
    private final static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        int price = inputView.inputIntegerCommand("구입금액을 입력해 주세요.");
        int count = inputView.inputIntegerCommand("수동으로 구매할 로또 수를 입력해 주세요.");
        lottoGame.buyManualSelectLotto(inputView.inputManualListCommand("수동으로 구매할 번호를 입력해 주세요.", count));
        resultView.printLottoCount(lottoGame.countLotto());
        resultView.printLottos(lottoGame.lottos());
        resultView.printWinningStatics(lottoGame.classifyRankLotto(
                lottoGame.registerWinningLottoNumbers(inputView.inputListCommand("지난 주 당첨 번호를 입력해 주세요."),
                        inputView.inputIntegerCommand("보너스 볼을 입력해 주세요."))), price);
    }




}
