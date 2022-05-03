package lotto;

import lotto.controller.LottoMarket;
import lotto.dto.ExtractLottoNumbers;
import lotto.dto.LottoResult;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        Money buyingMoney = new Money(InputView.inputBuyingMoney());
        Lottos buyingLottos = LottoMarket.buyLottos(buyingMoney, new RandomLottoGenerator());

        ResultView.printBuyingLottos(buyingLottos);

        String winnerLottoNumbers = InputView.inputWinnerLottoNumbers();
        Lotto winnerLotto = new Lotto(ExtractLottoNumbers.split(winnerLottoNumbers));

        LottoResult lottoResult = buyingLottos.getLottoResult(winnerLotto);

        ResultView.printResult(buyingMoney, lottoResult);
    }
}
