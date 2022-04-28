package lotto;

import lotto.controller.LottoMarket;
import lotto.dto.WinnerLottos;
import lotto.model.Lottos;
import lotto.model.RandomLottoGenerator;
import lotto.view.BuyInputView;
import lotto.view.BuyResultView;
import lotto.view.StatisticsResultView;
import lotto.view.WinnerInputView;

import java.util.List;
import java.util.Map;

public class LottoMain {
    public static void main(String[] args) {
        int buyingMoney = BuyInputView.inputBuyingMoney();
        List<Lottos> buyingLottos = LottoMarket.buyLottos(buyingMoney, new RandomLottoGenerator());

        BuyResultView.printBuyingLottos(buyingLottos);

        String winnerLottoNumbers = WinnerInputView.inputWinnerLottoNumbers();
        Lottos winnerLottos = new WinnerLottos(winnerLottoNumbers).getLottos();

        Map<Integer, Integer> lottoStatistics = LottoMarket.getLottoStatistics(buyingLottos, winnerLottos);

        StatisticsResultView.printStatistics(lottoStatistics);
    }
}
