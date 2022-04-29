package lotto;

import lotto.controller.LottoMarket;
import lotto.dto.WinnerLotto;
import lotto.model.Lotto;
import lotto.model.Money;
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
        List<Lotto> buyingLottos = LottoMarket.buyLottos(new Money(buyingMoney), new RandomLottoGenerator());

        BuyResultView.printBuyingLottos(buyingLottos);

        String winnerLottoNumbers = WinnerInputView.inputWinnerLottoNumbers();
        Lotto winnerLotto = new WinnerLotto(winnerLottoNumbers).getLotto();

        Map<Integer, Integer> lottoStatistics = LottoMarket.getLottoStatistics(buyingLottos, winnerLotto);

        StatisticsResultView.printStatistics(buyingMoney, lottoStatistics);
    }
}
