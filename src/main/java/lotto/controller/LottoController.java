package lotto.controller;

import lotto.domain.BoughtLottos;
import lotto.domain.LottoGenerator;
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
        try {
            run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void run() {
        Money money = moneyReader.readMoney();
        LottoGenerator lottoGenerator = new LottoGenerator();
        BoughtLottos boughtLottos = lottoGenerator.generate(money);
        boughtLottosWriter.printBoughtLottos(boughtLottos);

        final WinningLotto winningLotto = lottoReader.readWinningLotto();
        winningStatisticsWriter.printLottoStatistics(
                boughtLottos.winningResults(winningLotto)
        );
    }
}
