package controller;

import model.LotteryStatics;
import model.LottoStore;
import model.Lottos;
import model.WinNum;
import view.input.InputView;
import view.result.ResultView;

public class LottoController {
    public static void lottoAutoStart() {
        int buyAmount = InputView.inputBuyAmount();
        int passiveLottoCount = InputView.inputPassiveCount();

        LottoStore lottoStore = new LottoStore(buyAmount, passiveLottoCount);
        Lottos passiveLottos = lottoStore.buyPassive(InputView.inputPassiveLotto(passiveLottoCount));
        Lottos autoLottos = lottoStore.buyAuto();
        Lottos allLottos = autoLottos.addLottos(passiveLottos);
        ResultView.printLottoInfo(passiveLottos, autoLottos);

        WinNum winNum = new WinNum(InputView.inputWinnerLottoNum(), InputView.inputBonusBall());

        LotteryStatics lotteryStatics = new LotteryStatics(buyAmount, allLottos, winNum);
        ResultView.printStatics(lotteryStatics);
    }
}
