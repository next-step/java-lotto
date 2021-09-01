package lotto;

import static lotto.domain.WinLotto.of;
import static lotto.util.StringUtil.splitByComma;
import static lotto.view.InputView.inputBonusBall;
import static lotto.view.InputView.inputPurchaseManualLottoCount;
import static lotto.view.InputView.inputPurchaseManualLottos;
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
        int manualLottoCount = inputPurchaseManualLottoCount();
        Wallet wallet = lottoService.buyLotto(money, inputPurchaseManualLottos(manualLottoCount));

        printLottoCount(wallet);
        printLottosNumber(wallet);

        WinLotto winLotto = of(splitByComma(inputWinLottoNumbers()), inputBonusBall());
        LottoResult lottoResult = lottoService.calculateLottoResult(wallet, winLotto);
        printLottoResult(lottoResult, money);
    }

}
