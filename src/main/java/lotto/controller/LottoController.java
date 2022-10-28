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
        if (controller == null)
        {
            controller = new LottoController();
        }
        return controller;
    }

    public void run() {
        System.out.println("구입금액을 입력해 주세요.");
        LottoMoney lottoMoney = LottoMoney.from(InputView.getPrice());
        System.out.printf("%d개를 구매했습니다.\n", lottoMoney.getLottoCount());

        LottoList lottoList = LottoList.of(lottoMoney.getLottoCount());
        OutputView.printLottoList(lottoList.getLottoList());

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Lotto weekendLotto = Lotto.from(InputView.getWeekendNumbers());
        System.out.println("보너스 볼을 입력해 주세요.");
        LottoNumber weekendBonusNumber = LottoNumber.from(InputView.getWeekendBonusNumber());
        weekendLotto.validBonusNumber(weekendBonusNumber);

        LottoWinners winners = LottoWinners.of(lottoList.getLottoList(), weekendLotto, weekendBonusNumber);

        OutputView.printWinner(winners.getWinners());
        OutputView.printYield(lottoMoney.calYield(winners.getTotalPrize()));
    }
}
