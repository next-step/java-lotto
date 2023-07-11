package lotto.controller;

import lotto.domain.Ball;
import lotto.domain.BoughtLottos;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoResults;
import lotto.domain.Money;
import lotto.view.BoughtLottosWriter;
import lotto.view.LottoReader;
import lotto.view.MoneyReader;
import lotto.view.WinningStatisticsWriter;

public class LottoController {

    private final MoneyReader moneyReader;
    private final LottoReader lottoReader;
    private final BoughtLottosWriter boughtLottosWriter;
    private final WinningStatisticsWriter winningStatisticsWriter;

    public LottoController(
            final MoneyReader moneyReader,
            final LottoReader lottoReader,
            final BoughtLottosWriter boughtLottosWriter,
            final WinningStatisticsWriter winningStatisticsWriter
    ) {
        this.moneyReader = moneyReader;
        this.lottoReader = lottoReader;
        this.boughtLottosWriter = boughtLottosWriter;
        this.winningStatisticsWriter = winningStatisticsWriter;
    }

    public void startLotto() {
        Money money = moneyReader.readMoney();
        LottoGenerator lottoGenerator = new LottoGenerator();
        BoughtLottos boughtLottos = lottoGenerator.generate(money);
        boughtLottosWriter.printBoughtLottos(boughtLottos);

        Lotto winningLotto = lottoReader.readWinningLotto();
        Ball bonusBall = lottoReader.readBonusBall();

        LottoResults lottoResults = boughtLottos.winningResults(winningLotto, bonusBall);
        winningStatisticsWriter.printLottoStatistics(lottoResults.getWinningStatistics());
    }
}
