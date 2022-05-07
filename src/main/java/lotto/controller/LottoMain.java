package lotto.controller;

import lotto.dto.ExtractLottoNumbers;
import lotto.dto.LottoResult;
import lotto.model.Lotto;
import lotto.model.LottoMarket;
import lotto.model.LottoNumber;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.RandomLottoGenerator;
import lotto.model.WinnerLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {
    public static void main(String[] args) {
        Money buyingMoney = new Money(InputView.inputBuyingMoney());
        Lottos buyingLottos = LottoMarket.buyLottos(buyingMoney, new RandomLottoGenerator());

        ResultView.printBuyingLottos(buyingLottos);

        LottoResult lottoResult = buyingLottos.extractLottoResult(inputWinnerLotto());

        ResultView.printResult(buyingMoney, lottoResult);
    }

    private static WinnerLotto inputWinnerLotto() {
        String winnerLottoNumbers = InputView.inputWinnerLottoNumbers();

        Lotto winnerLotto = new Lotto(ExtractLottoNumbers.split(winnerLottoNumbers));
        LottoNumber bonusNumber = LottoNumber.valueOf(InputView.inputBonusLottoNumber());

        return new WinnerLotto(winnerLotto, bonusNumber);
    }
}
