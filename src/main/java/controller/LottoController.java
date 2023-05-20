package controller;

import model.*;
import view.input.InputView;
import view.result.ResultView;

import java.util.List;

public class LottoController {
    public static void lottoAutoStart() {
        int buyAmount = InputView.inputBuyAmount();

        LottoStore lottoStore = new LottoStore();
        Lottos lottos = lottoStore.buy(buyAmount);
        ResultView.printLottoInfo(lottos.getLottos());

        WinNum winNum = new WinNum(InputView.inputWinnerLottoNum(), InputView.inputBonusBall());

        LotteryStatics lotteryStatics = new LotteryStatics(buyAmount, lottos, winNum);
        ResultView.printStatics(lotteryStatics);
    }
}
