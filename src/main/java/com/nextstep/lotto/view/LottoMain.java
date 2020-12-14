package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.LottoSeller;
import com.nextstep.lotto.domain.Lottos;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        LottoMain.run();
    }

    public static void run() {
        int price = InputView.inputPrice();
        Lottos lottos = LottoSeller.buy(price);
        ResultView.printBuy(lottos);
        List<Integer> winnerNumbers = InputView.inputWinnerNumbers();
        int bonusNumber = InputView.inputBonusNumber();
        ResultView.printStatistics(lottos.getStatistics(winnerNumbers, bonusNumber));
    }
}
