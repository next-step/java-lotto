package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoMoney;
import lotto.domain.LottoNumber;
import lotto.domain.LottoWinners;
import lotto.domain.strategy.LottoAutoConstructStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;


public class LottoController {

    private static LottoController controller;

    public static LottoController getLottoController() {
        if (controller == null) {
            controller = new LottoController();
        }
        return controller;
    }

    public void run() {
        LottoMoney lottoMoney = LottoMoney.from(InputView.getPrice());

        int manualCount = InputView.getManualLottoCount(lottoMoney.getLottoCount());
        int autoCount = lottoMoney.getLottoCount() - manualCount;

        LottoList lottoList = LottoList.from(InputView.getManualNumbers(manualCount));
        lottoList.add(new LottoAutoConstructStrategy().create(autoCount));

        OutputView.printPriceCount(manualCount, autoCount);
        OutputView.printLottoList(lottoList.getLottoList());

        Lotto weekendLotto = Lotto.from(InputView.getWeekendNumber());
        LottoNumber weekendBonusNumber = LottoNumber.from(InputView.getWeekendBonusNumber());

        LottoWinners winners = LottoWinners.of(lottoList.getLottoList(), weekendLotto, weekendBonusNumber);

        OutputView.printWinner(winners.getWinners());
        OutputView.printYield(lottoMoney.calYield(winners.getTotalPrize()));
    }
}
