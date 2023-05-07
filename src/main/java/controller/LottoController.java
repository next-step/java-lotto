package controller;

import model.*;
import view.input.InputView;
import view.result.ResultView;

import java.util.List;

public class LottoController {

    public static void LottoAutoStart() {

        int buyAmount = InputView.inputBuyAmount();

        LottoStore lottoStore = new LottoStore(buyAmount);

        LottoRandomGenerator lottoGenerator = new LottoRandomGenerator();
        lottoGenerator.generatorLotto(lottoStore.getCount());
        List<Lotto> lottos = lottoGenerator.getLottos();

        ResultView.printLottoInfo(lottos, lottoStore.getCount());

        Lotto winNum = new Lotto(InputView.inputWinnerLottoNum());

        WinRule winRule = new WinRule();

        LotteryStatics lotteryStatics = new LotteryStatics(winRule, lottoGenerator.getLottos(), winNum.getLotto());

        ResultView.printWinnerMessage(lotteryStatics.getLotteryStatics());

        int totalPriceMoney = lotteryStatics.getTotalPrice();

        Gross gross = new Gross(totalPriceMoney, buyAmount);
        ResultView.printTotalGross(gross.getGross());
    }
}
