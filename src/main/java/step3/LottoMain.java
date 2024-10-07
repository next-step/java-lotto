package step3;

import step3.model.LottoMachine;
import step3.model.Lotto;
import step3.model.LottoConfirmation;
import step3.uiView.InputView;
import step3.uiView.ResultView;

public class LottoMain {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        int money = inputView.inputMoney(); //돈입력

        LottoMachine lottoMachine = new LottoMachine();
        Lotto lotto = lottoMachine.buyLotto(money); //로또 구매

        resultView.lottoView(lotto);

        String prizeNum = inputView.inputPrizeNum(); //당첨번호 입력
        int bonusNum = inputView.inputBonusNum(); //보너스번호 입력

        LottoConfirmation lottoConfirmation = new LottoConfirmation();
        lottoConfirmation.checkPrizeNum(lotto, prizeNum, bonusNum); //번호 맞춰보기

        resultView.lottoPrizeView(lottoConfirmation);
        resultView.lottoRateReturn(lottoConfirmation);
    }
}
