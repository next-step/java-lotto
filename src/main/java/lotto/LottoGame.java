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

        PrizeLotto prizeLotto = PrizeLotto.of(InputView.lastWeekLottoPrizeNumber(), InputView.inputBonusball());
        Reward reward = lottos.matchPrizeNumber(prizeLotto);

        ResultView.outputPrizeStatistics(reward);
        ResultView.outputTotalEarningRate(reward, lottoPrice);

    }
}