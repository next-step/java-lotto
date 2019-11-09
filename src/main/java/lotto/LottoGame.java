package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.LottoGenerator;
import lotto.view.LottoInputView;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-09 23:33
 */
public class LottoGame {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(new LottoAmount(LottoInputView.inputPurchaseAmount()));
        lottoMachine.purchase(new LottoGenerator());
    }
}
