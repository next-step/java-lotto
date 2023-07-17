package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.domain.game.LottoCount;
import lotto.domain.game.Lottos;
import lotto.domain.game.NumberGeneratorImpl;
import lotto.domain.game.Payment;
import lotto.domain.game.WinningNumber;
import lotto.domain.statistics.LottoMatch;
import lotto.domain.statistics.LottoResults;
import lotto.domain.statistics.ProfitRate;
import lotto.view.LottoView;

public final class LottoController {

    public void run() {
        LottoView lottoView = new LottoView();
        int money = lottoView.readPayment();
        int countLottoManual = lottoView.readLottoManualCount();

        Payment payment = new Payment(money);
        LottoCount lottoCount = new LottoCount(payment, countLottoManual);
        List<String> lottoManuals = lottoView.readLottoManualNumbers(lottoCount);

        Lottos lottos = new Lottos(lottoCount, lottoManuals, new NumberGeneratorImpl());
        lottoView.printLottoCount(lottoCount);
        lottoView.printLottos(lottos);

        String winningLotto = lottoView.readWinningLotto();
        int bonusBall = lottoView.readBonusBall();
        WinningNumber winningNumber = new WinningNumber(winningLotto, bonusBall);

        Map<LottoMatch, Integer> resultMap = lottos.calculateResult(winningNumber);
        lottoView.printLottoResult(new LottoResults(resultMap));
        lottoView.printProfitRate(new ProfitRate(payment, resultMap));

    }
}
