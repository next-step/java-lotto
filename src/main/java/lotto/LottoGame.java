package lotto;

import lotto.domain.LottoAmount;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;
import lotto.domain.WinningLottoAmount;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

import java.util.List;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-09 23:33
 */
public class LottoGame {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(LottoAmount.of(LottoInputView.inputPurchaseAmount()));
        lottoMachine.purchase(new LottoGenerator());
        LottoResultView.printLottoPurchaseCount(lottoMachine.getLottoCount());
        LottoResultView.printPurchasedLotto(lottoMachine.getLottos());
        LottoResult lottoResult = new LottoResult(LottoInputView.inputWinningNumber());
        LottoResultView.printWinningLotto(lottoResult.getWinningLottoAmount(lottoMachine.getLottos()));
        LottoResultView.printRateOfReturn(lottoResult.rateOfReturn(lottoMachine.getLottos()));
    }
}
