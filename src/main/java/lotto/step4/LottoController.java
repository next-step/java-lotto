package lotto.step4;

import lotto.step4.domain.*;
import lotto.step4.view.InputView;
import lotto.step4.view.ResultView;

import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        int money = InputView.inputLottoPrice();
        int manualLottoCount = InputView.inputManualLottoCount();
        LottoShop lottoShop = new LottoShop(manualLottoCount);
        int autoCount = lottoShop.receiveMoney(money);
        List<Lottery> manualLotteries = InputView.inputManualLottoNumbers(manualLottoCount);
        Lotteries lotteries = new Lotteries(autoCount, manualLotteries);
        ResultView.printLottoInfo(manualLottoCount,autoCount);
        ResultView.printLottoNumbers(lotteries);

    }
}
