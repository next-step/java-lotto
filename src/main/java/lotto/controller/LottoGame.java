package lotto.controller;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    public void run() {
        Lottos lottos = new Lottos(InputView.readPurchasingAmount());// 로또 구매 & 생성
        ResultView.printNumbersForLottos(lottos);// 구매한 로또 출력
        LottoResult lottoResult = lottos.retrieveStatistics(InputView.readWinningLottoNumbers());// 지난 주 당첨 번호 입력
        ResultView.printStatisticsForLottos(lottoResult);// 로또 당첨 통계 출력
    }
}
