package controller;

import model.LotteryStatics;
import model.Lotto;
import model.LottoStore;
import view.input.InputView;
import view.result.ResultView;

import java.util.List;

public class LottoController {

    public static void LottoAutoStart() {
        int buyAmount = InputView.inputBuyAmount();

        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.Buy(buyAmount);
        ResultView.printLottoInfo(lottos);

        Lotto winNum = new Lotto(InputView.inputWinnerLottoNum());

        LotteryStatics lotteryStatics = new LotteryStatics(buyAmount, lottos, winNum.getLotto());
        ResultView.printStatics(lotteryStatics);

    }
}
