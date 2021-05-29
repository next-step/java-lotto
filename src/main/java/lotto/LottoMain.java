package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Pay userPay = inputView.payForLotto();
        BuyLottoCount userBuyLottoCount = inputView.manualLottoCount(userPay);
        Lottos userLottos = inputView.buyManualLotto(userBuyLottoCount);

        ResultView.buyLottoInfo(userLottos, userBuyLottoCount);
        Lotto winLotto = inputView.inputWinLottoNumber();

        LottoRecord userLottoRecord = userLottos.compareWinLotto(winLotto, inputView.inputBonusNumber(winLotto));
        ResultView.printResult(userLottoRecord);
    }
}
