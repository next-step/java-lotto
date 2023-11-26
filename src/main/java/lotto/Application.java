package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

public class Application {

    private final static InputView inputView = new InputView();
    private final static ResultView resultView = new ResultView();

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        int price = inputView.inputIntegerCommand("구입금액을 입력해 주세요.");
        lottoGame.buyLotto(price);
        resultView.printLottoCount(lottoGame.countLotto());
        resultView.printLottos(lottoGame.lottos());
        lottoGame.registerWinningLotto(inputView.inputListCommand("지난 주 당첨 번호를 입력해 주세요."));
        lottoGame.registerBonusBall(inputView.inputIntegerCommand("보너스 볼을 입력해 주세요."));
        resultView.printWinningStatics(lottoGame.classifyRankLotto(), price);
    }




}
