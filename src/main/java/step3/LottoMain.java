package step3;

import step3.model.ManualLotto;
import step3.model.PurchasedLotto;
import step3.model.LottoConfirmation;
import step3.model.LottoMachine;
import step3.uiView.InputView;
import step3.uiView.ResultView;

import java.util.List;

public class LottoMain {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        int money = inputView.inputMoney(); //돈입력

        int manualLottoCount = inputView.inputManualLottoCount();
        List<String> manualLottoList = inputView.inputManualLotto(manualLottoCount);

        ManualLotto manualLotto = new ManualLotto(manualLottoList);

        LottoMachine lottoMachine = new LottoMachine();
        PurchasedLotto purchasedLotto = lottoMachine.buyLotto(money, manualLotto); //로또 구매

        resultView.lottoView(purchasedLotto, manualLotto);

        String prizeNum = inputView.inputPrizeNum(); //당첨번호 입력
        int bonusNum = inputView.inputBonusNum(); //보너스번호 입력

        LottoConfirmation lottoConfirmation = new LottoConfirmation();
        lottoConfirmation.checkPrizeNum(purchasedLotto, prizeNum, bonusNum); //번호 맞춰보기

        resultView.lottoPrizeView(lottoConfirmation);
        resultView.lottoRateReturn(lottoConfirmation);
    }
}
