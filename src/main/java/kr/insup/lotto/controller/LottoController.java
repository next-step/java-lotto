package kr.insup.lotto.controller;

import kr.insup.lotto.config.LottoConfig;
import kr.insup.lotto.domain.Lotto;
import kr.insup.lotto.domain.Lottos;
import kr.insup.lotto.domain.Statistics;
import kr.insup.lotto.utils.WinningNumberParser;
import kr.insup.lotto.view.LottoView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        //구매금액 입력
        int price = LottoView.getPrice();
        LottoView.showPurchase(price / LottoConfig.LOTTO_PRICE);
        Lottos lottos = new Lottos(price / LottoConfig.LOTTO_PRICE);
        LottoView.showLottoList(lottos);
        //당첨번호 입력
        Lotto winningNumber = WinningNumberParser.parseWinningNumberToList(LottoView.showWinningNumber());
        Statistics statistics = lottos.statistics(winningNumber);
        LottoView.showWinningStatistic(statistics);
    }
}
