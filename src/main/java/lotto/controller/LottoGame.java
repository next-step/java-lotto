package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    public void run() {
        int purchasedAmount = InputView.readPurchasingAmount();// 로또 구입금액 입력
        ResultView.printPurchasedLottoSize(purchasedAmount);// 로또 구입 갯수 출력
        Lottos lottos = new Lottos(purchasedAmount / Lotto.PRICE);// 로또 구매 & 생성
        ResultView.printNumbersForLottos(lottos);// 구매한 로또 출력
        LottoResult lottoResult = lottos.retrieveStatistics(InputView.readWinningLottoNumbers());// 지난 주 당첨 번호 입력
        ResultView.printStatisticsForLottos(lottoResult);// 로또 당첨 통계 출력
    }
}
