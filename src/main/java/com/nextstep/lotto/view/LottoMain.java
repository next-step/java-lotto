package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.LottoSeller;
import com.nextstep.lotto.domain.Lottos;

public class LottoMain {
    public static void main(String[] args) {
        new LottoMain().run();
    }

    public void run() {
        int price = InputView.inputPrice();
        int buyCount = LottoSeller.count(price);
        Lottos lottos = LottoSeller.buy(buyCount);
        ResultView.printBuy(buyCount, lottos);
        String winnerNumbers = InputView.inputWinnerNumbers();
        ResultView.printStatistics(lottos.getStatistics(winnerNumbers));
    }
}
