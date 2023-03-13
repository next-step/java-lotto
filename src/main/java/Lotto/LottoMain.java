package Lotto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Lottos lottos = new Lottos();
        lottos.buyLottos(inputView.inputBuyingPrice());
        ResultBuyView resultBuyView = new ResultBuyView();
        resultBuyView.printLottos(lottos);
        lottos.setWinLotto(inputView.inputHitNumber());
        lottos.setBonusNumber(inputView.inputBonusNumber());
        lottos.executeLotto();
        ResultView resultView = new ResultView(lottos);
        resultView.printWinResult();
    }
}