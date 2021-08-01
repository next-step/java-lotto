package lotto;

import lotto.domain.LottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String args[]){
        int purchaseAmount = InputView.getPurchaseAmount();

        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);

        int lottoCount = lottoMachine.getPurchaseLottoCount();

        ResultView.countOfLotto(lottoCount);

        for(int i = 0 ; i < lottoMachine.getPurchaseLottoCount(); i++){
            ResultView.printLottoNumber(lottoMachine.generateLottoNumber());
        }

    }
}
