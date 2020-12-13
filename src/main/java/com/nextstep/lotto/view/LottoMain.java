package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.LottoSeller;
import com.nextstep.lotto.domain.Lottos;

public class LottoMain {
    public static void main(String[] args) {
        new LottoMain().run();
    }

    public void run() {
        int price = InputView.inputPrice();
        Lottos lottos = LottoSeller.buy(price);
        ResultView.printBuy(lottos);
        String winnerNumbers = InputView.inputWinnerNumbers();
        ResultView.printStatistics(lottos.getStatistics(winnerNumbers));
    }
}
