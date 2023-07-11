package lotto;

import lotto.controller.LottoController;
import lotto.view.BoughtLottosWriter;
import lotto.view.LottoReader;
import lotto.view.MoneyReader;
import lotto.view.WinningStatisticsWriter;

public class LottoMain {

    public static void main(String[] args) {
        MoneyReader moneyReader = new MoneyReader();
        LottoReader lottoReader = new LottoReader();
        BoughtLottosWriter boughtLottosWriter = new BoughtLottosWriter();
        WinningStatisticsWriter winningStatisticsWriter = new WinningStatisticsWriter();

        LottoController lottoController = new LottoController(
                moneyReader, lottoReader, boughtLottosWriter, winningStatisticsWriter);
        lottoController.startLotto();
    }
}
