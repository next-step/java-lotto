package lotto;

import lotto.controller.LottoMarket;
import lotto.dto.WinnerLotto;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Map;

public class LottoMain {
    public static void main(String[] args) {
        Money buyingMoney = new Money(InputView.inputBuyingMoney());
        List<Lotto> buyingLottos = LottoMarket.buyLottos(buyingMoney, new RandomLottoGenerator());

        ResultView.printBuyingLottos(buyingLottos);

        String winnerLottoNumbers = InputView.inputWinnerLottoNumbers();
        Lotto winnerLotto = new WinnerLotto(winnerLottoNumbers).getLotto();

        Map<Integer, Integer> lottoStatistics = LottoMarket.getLottoStatistics(buyingLottos, winnerLotto);

        ResultView.printStatistics(buyingMoney, lottoStatistics);
    }
}
