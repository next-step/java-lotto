package lotto;

import static lotto.domain.Number.generateNumbers;

import java.util.List;
import java.util.Scanner;
import lotto.application.LottoService;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.Number;
import lotto.domain.Wallet;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        ResultView resultView = new ResultView();

        LottoService lottoService = new LottoService();
        Money money = new Money(inputView.inputPurchaseMoney());
        Wallet wallet = lottoService.buyLotto(money);

        resultView.printLottoCount(wallet);
        resultView.printLottosNumber(wallet);

        List<Number> numbers = generateNumbers(inputView.inputWinLottoNumbers().split(","));
        Lotto winLotto = new Lotto(numbers);
        LottoResult lottoResult = lottoService.calculateLottoResult(wallet, winLotto);
        resultView.printLottoResult(lottoResult);
    }

}
