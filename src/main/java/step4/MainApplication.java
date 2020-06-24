package step4;

import step4.domain.LottoGame;
import step4.domain.PurchaseInfo;
import step4.domain.lotto.Lotto;
import step4.domain.lotto.WinningLotto;
import step4.view.InputView;
import step4.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {

    public static void main(String[] args) {
        // ready
        String payMoney = InputView.inputPayMoney();
        String countForSelf = InputView.inputCountForSelf();
        PurchaseInfo purchaseInfo = new PurchaseInfo(payMoney, countForSelf);
        // set
        List<Lotto> selfChosenLottos = new ArrayList<>();
        for (int i = 0; i < purchaseInfo.getSelfChooseCount(); i++) {
            selfChosenLottos.add(new Lotto(InputView.inputChooseNumbersForSelf()));
        }
        LottoGame lottoGame = LottoGame.create(purchaseInfo, selfChosenLottos);
        //LottoGame lottoGame = LottoGame.create(purchaseInfo);
        OutputView.outputLottoList(lottoGame);
        // get Wining Number
        String winingNumber = InputView.inputWiningNumber();
        String bonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = WinningLotto.of(winingNumber, bonusNumber);
        // matching numbers
        lottoGame.matchingWinningNumbers(winningLotto);
        // total result
        lottoGame.totalResult();
    }

}
