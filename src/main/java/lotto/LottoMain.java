package lotto;

import lotto.controller.LottoMarket;
import lotto.dto.ExtractLottoNumbers;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Map;

public class LottoMain {
    public static void main(String[] args) {
        Money buyingMoney = new Money(InputView.inputBuyingMoney());
        Lottos buyingLottos = LottoMarket.buyLottos(buyingMoney, new RandomLottoGenerator());

        ResultView.printBuyingLottos(buyingLottos);

        String winnerLottoNumbers = InputView.inputWinnerLottoNumbers();
        Lotto winnerLotto = new Lotto(ExtractLottoNumbers.split(winnerLottoNumbers));

        Map<Integer, Integer> lottoStatistics = buyingLottos.getLottoStatistics(winnerLotto);

        ResultView.printStatistics(buyingMoney, lottoStatistics);
    }
}
