package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;

import static lotto.view.InputView.*;
import static lotto.view.ResultView.*;

public class LottoGame {

    public void run() {
        int purchasedAmount = readPurchasingAmount();// 로또 구입금액 입력
        printPurchasedLottoSize(purchasedAmount);// 로또 구입 갯수 출력
        Lottos lottos = new Lottos(purchasedAmount / Lotto.PRICE);// 로또 구매 & 생성
        printNumbersForLottos(lottos);// 구매한 로또 출력
        LottoResult lottoResult = lottos.retrieveStatistics(readWinningLottoNumbers(), readBonusLottoNumber());// 지난 주 당첨 번호 / 보너스 번호 입력
        printStatisticsForLottos(lottoResult);// 로또 당첨 통계 출력
    }
}
