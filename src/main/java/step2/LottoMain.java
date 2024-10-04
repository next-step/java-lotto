package step2;

import step2.model.Lotto;
import step2.model.LottoMachine;
import step2.uiView.InputView;
import step2.uiView.ResultView;

public class LottoMain {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        int money = inputView.inputMoney(); //돈입력

        LottoMachine lottoMachine = new LottoMachine();
        Lotto lotto = lottoMachine.buyLotto(money); //로또 구매

        resultView.lottoView(lotto);

        String prizeNum = inputView.inputPrizeNum(); //당첨번호 입력

        lotto.checkPrizeNum(prizeNum); //번호 맞춰보기

        resultView.lottoPrizeView(lotto);
    }
}
