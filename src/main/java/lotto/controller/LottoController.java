package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoMoney;
import lotto.domain.LottoNumber;
import lotto.domain.LottoWinners;
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

        LottoList lottoList = LottoList.of(lottoMoney.getLottoCount()
            , InputView.getManualLottoCount(lottoMoney.getLottoCount()));

        OutputView.printLottoList(lottoList);

        Lotto weekendLotto = Lotto.from(InputView.getWeekendNumber());

        LottoNumber weekendBonusNumber = weekendLotto
            .validBonusNumber(InputView.getWeekendBonusNumber());

        LottoWinners winners = LottoWinners.of(lottoList.getLottoList(), weekendLotto, weekendBonusNumber);

        OutputView.printWinner(winners.getWinners());
        OutputView.printYield(lottoMoney.calYield(winners.getTotalPrize()));
    }
}
