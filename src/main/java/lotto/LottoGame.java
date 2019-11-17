package lotto;

import lotto.domain.LottoAmount;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResult;
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
        LottoAmount lottoAmount = LottoAmount.ofManual(LottoInputView.inputPurchaseAmount()
                , LottoInputView.inputPurchaseManualLottoCount());
        LottoMachine lottoMachine = new LottoMachine(lottoAmount);
        List<String> manualLottoNumbers = LottoInputView.inputPurchaseManualLotto(lottoAmount.getManualLottoCount());
        lottoMachine.purchaseLotto(new LottoGenerator(), manualLottoNumbers);
        LottoResultView.printLottoPurchaseCount(lottoMachine.getAutoLottoCount(), lottoMachine.getManualLottoCount());
        LottoResultView.printPurchasedLotto(lottoMachine.getLottos());
        LottoResult lottoResult = LottoResult.ofBonusNo(LottoInputView.inputWinningNumber(), LottoInputView.inputBonusNo());
        LottoResultView.printWinningLotto(lottoResult.getWinningLottoAmount(lottoMachine.getLottos()));
        LottoResultView.printRateOfReturn(lottoResult.rateOfReturn(lottoMachine.getLottos()));
    }
}
