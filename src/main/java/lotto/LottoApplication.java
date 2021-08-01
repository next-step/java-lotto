package lotto;

import lotto.domain.LottoMachine;
import lotto.view.InputView;

public class LottoApplication {
    public static void main(String args[]){
        int purchaseAmount = InputView.getPurchaseAmount();

        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);

    }
}
