package lotto.controller;

import java.util.List;
import lotto.domain.game.LottoCount;
import lotto.domain.game.Lottos;
import lotto.domain.game.NumberGenerator;
import lotto.domain.game.Payment;
import lotto.domain.game.WinningNumber;
import lotto.domain.statistics.LottoResults;
import lotto.domain.statistics.LottoStatistics;
import lotto.view.LottoView;

public final class LottoController {

    public void run() {
        // 1-1. 구입
        LottoView lottoView = new LottoView();
        int money = lottoView.readPayment();
        int countLottoManual = lottoView.readLottoManualCount();

        Payment payment = new Payment(money);
        LottoCount lottoCount = new LottoCount(payment, countLottoManual);
        List<String> lottoManuals = lottoView.readLottoManualNumbers(lottoCount);

        // 1-2. 구입 갯수 & 구입 로또 번호 출력
        NumberGenerator numberGenerator = new NumberGenerator();
        Lottos lottos = new Lottos(lottoCount, lottoManuals, numberGenerator);
        lottoView.printLottoCount(lottoCount);
        lottoView.printLottos(lottos);

        // 2. 당첨 번호 & 보너스 볼 입력
        String winningLotto = lottoView.readWinningLotto();
        int bonusBall = lottoView.readBonusBall();
        WinningNumber winningNumber = new WinningNumber(winningLotto, bonusBall);

        // 3. 당첨 통계 출력
        LottoStatistics lottoStatistics = new LottoStatistics(lottos, winningNumber, payment);
        LottoResults lottoResults = new LottoResults(lottoStatistics);
        lottoView.printLottoResult(lottoResults);
        lottoView.printProfitRate(lottoStatistics);

    }
}
