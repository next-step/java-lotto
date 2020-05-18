package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoUser {

    public static void main(String[] args){
        int price = InputView.requestPrice();

        LottoSeller lottoSeller = new LottoSeller();
        Lottos lottos = lottoSeller.sell(price);

        OutputView.printLottos(lottos.getLottos());
    }

}
