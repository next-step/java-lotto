package lotto;

import static lotto.domain.LottoNumber.generateNumbers;
import static lotto.view.InputView.inputBonusBall;
import static lotto.view.InputView.inputPurchaseMoney;
import static lotto.view.InputView.inputWinLottoNumbers;
import static lotto.view.ResultView.printLottoCount;
import static lotto.view.ResultView.printLottoResult;
import static lotto.view.ResultView.printLottosNumber;

import java.util.List;
import java.util.Scanner;
import lotto.application.LottoService;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.LottoNumber;
import lotto.domain.Wallet;
import lotto.domain.WinLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

    public static void main(String[] args) {

        LottoService lottoService = new LottoService();
        Money money = new Money(inputPurchaseMoney());
        Wallet wallet = lottoService.buyLotto(money);

        printLottoCount(wallet);
        printLottosNumber(wallet);

        List<LottoNumber> numbers = generateNumbers(inputWinLottoNumbers().split(","));
        LottoNumber bonus = new LottoNumber(inputBonusBall());
        WinLotto winLotto = new WinLotto(new Lotto(numbers), bonus);
        LottoResult lottoResult = lottoService.calculateLottoResult(wallet, winLotto);
        printLottoResult(lottoResult, money);
    }

}
