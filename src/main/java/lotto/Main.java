package lotto;

import static lotto.domain.WinLotto.of;
import static lotto.view.InputView.inputBonusBall;
import static lotto.view.InputView.inputPurchaseMoney;
import static lotto.view.InputView.inputWinLottoNumbers;
import static lotto.view.ResultView.printLottoCount;
import static lotto.view.ResultView.printLottoResult;
import static lotto.view.ResultView.printLottosNumber;

import lotto.application.LottoService;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.Wallet;
import lotto.domain.WinLotto;

public class Main {

    public static void main(String[] args) {
        LottoService lottoService = new LottoService();
        Money money = new Money(inputPurchaseMoney());
        Wallet wallet = lottoService.buyLotto(money);

        printLottoCount(wallet);
        printLottosNumber(wallet);

        WinLotto winLotto = of(inputWinLottoNumbers().split(","), inputBonusBall());
        LottoResult lottoResult = lottoService.calculateLottoResult(wallet, winLotto);
        printLottoResult(lottoResult, money);
    }

}
