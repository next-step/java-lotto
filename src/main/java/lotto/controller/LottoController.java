package lotto.controller;

import lotto.domain.Ball;
import lotto.domain.BoughtLottos;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResults;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.BoughtLottosWriter;
import lotto.view.LottoReader;
import lotto.view.MoneyReader;
import lotto.view.WinningStatisticsWriter;

public class LottoController {

    private final MoneyReader moneyReader;
    private final LottoReader lottoReader;
    private final BoughtLottosWriter boughtLottosWriter;
    private final WinningStatisticsWriter winningStatisticsWriter;
    private final LottoGenerator lottoGenerator;

    public LottoController(
            final MoneyReader moneyReader,
            final LottoReader lottoReader,
            final BoughtLottosWriter boughtLottosWriter,
            final WinningStatisticsWriter winningStatisticsWriter,
            final LottoGenerator lottoGenerator
    ) {
        this.moneyReader = moneyReader;
        this.lottoReader = lottoReader;
        this.boughtLottosWriter = boughtLottosWriter;
        this.winningStatisticsWriter = winningStatisticsWriter;
        this.lottoGenerator = lottoGenerator;
    }

    public void startLotto() {
        Money money = moneyReader.readMoney();

        BoughtLottos boughtLottos = lottoGenerator.generate(money);
        boughtLottosWriter.printBoughtLottos(boughtLottos);

        Lotto winningBalls = lottoReader.readWinningLotto();
        Ball bonusBall = lottoReader.readBonusBall();
        WinningLotto winningLotto = new WinningLotto(winningBalls, bonusBall);

        LottoResults lottoResults = boughtLottos.winningResults(winningLotto);
        winningStatisticsWriter.printLottoStatistics(lottoResults.getWinningStatistics());
    }
}
