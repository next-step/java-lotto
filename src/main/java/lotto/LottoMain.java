package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoBuy lottoBuy = new LottoBuy();
        Lottos userLottos = lottoBuy.buyLotto(inputView.payForLotto());
        ResultView.buyLottoInfo(userLottos);
        Lotto winLotto =  inputView.inputWinLottoNumber();

        LottoRecord userLottoRecord = userLottos.compareWinLotto(winLotto, inputView.inputBonusNumber(winLotto));
        ResultView.printResult(userLottoRecord);
    }
}
