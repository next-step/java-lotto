package controller;

import model.LotteryStatics;
import model.Lotto;
import model.LottoStore;
import view.input.InputView;
import view.result.ResultView;

import java.util.List;

public class LottoController {

    public static void lottoAutoStart() {
        int buyAmount = InputView.inputBuyAmount();

        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.buy(buyAmount);
        ResultView.printLottoInfo(lottos);

        Lotto winNum = new Lotto(InputView.inputWinnerLottoNum(), InputView.inputBonusBall());

        LotteryStatics lotteryStatics = new LotteryStatics(buyAmount, lottos, winNum.getLotto());
        ResultView.printStatics(lotteryStatics);

    }
}
