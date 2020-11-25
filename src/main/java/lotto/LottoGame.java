package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    public static void main(String[] args) {

        LottoPrice lottoPrice = LottoPrice.from(InputView.inputPurchasePrice());

        LottoShop lottoShop = new LottoShop();
        Lottos lottos = lottoShop.purchase(lottoPrice, new LottoAutoMachine());

        ResultView.outputPurchaseQuantity(lottos.quantity());

        ResultView.outputLottos(lottos);

        PrizeLotto prizeLotto = new PrizeLotto(InputView.lastWeekLottoPrizeNumber());
        Reward reward = lottos.matchPrizeNumber(prizeLotto);

        ResultView.outputPrizeStatistics(reward);
        ResultView.outputTotalEarningRate(reward, lottoPrice);

    }
}