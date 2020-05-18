package lotto;

import lotto.domain.LottoSeller;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoCustomer {

    public static void main(String[] args){
        int price = InputView.requestPrice();

        LottoSeller lottoSeller = new LottoSeller();
        Lottos lottos = lottoSeller.sell(price);

        OutputView.printLottos(lottos.getLottos());
    }

}
