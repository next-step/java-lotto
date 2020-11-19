package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {

        LottoPrice lottoPrice = new LottoPrice(InputView.inputPurchasePrice());

        LottoShop lottoShop = new LottoShop();
        Lottos lottos = lottoShop.purchase(lottoPrice, new LottoAutoMachine());

        ResultView.outputPurchaseQuantity(lottos.quantity());

        ResultView.outputLottos(lottos);

        List<Integer> prizeNumbers = InputView.lastWeekLottoPrizeNumber();
        Reward reward = lottos.matchPrizeNumber(prizeNumbers);

        ResultView.outputPrizeStatistics(reward);
        ResultView.outputTotalEarningRate(reward, lottoPrice);

    }
}