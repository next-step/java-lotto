package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoGenerator;
import lotto.view.BoughtLottosWriter;
import lotto.view.LottoReader;
import lotto.view.MoneyReader;
import lotto.view.WinningStatisticsWriter;

public class LottoMain {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
                new MoneyReader(),
                new LottoReader(),
                new BoughtLottosWriter(),
                new WinningStatisticsWriter(),
                LottoGenerator.getInstance()
        );

        lottoController.startLotto();
    }
}
