package lotto;

import java.util.List;
import lotto.domain.LottoManager;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.input.LottoInput;
import lotto.output.LottoOutput;

public class LottoApplication {

    private final LottoInput input;
    private final LottoOutput output;

    public LottoApplication() {
        this.input = new LottoInput();
        this.output = new LottoOutput();
    }

    public void run() {
        Money purchaseMoney = inputPurchaseMoney();
        output.printQuantity(purchaseMoney.calculateQuantity(new Money(LottoManager.LOTTO_PRICE)));
        LottoManager manager = LottoManager.from(purchaseMoney);

        output.printLottos(manager);
        System.out.println();

        WinningLotto winningLotto = inputWinningLotto();
        printResult(manager.getResult(winningLotto));
    }

    private Money inputPurchaseMoney() {
        output.printAskPurchaseMoney();
        return new Money(input.inputPurchaseMoney());
    }

    private WinningLotto inputWinningLotto() {
        output.printAskWinningNumbers();
        List<Integer> winningNumbers = input.inputWinningNumbers();
        output.printAskBonus();
        int bonus = input.inputBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);
        System.out.println();
        return winningLotto;
    }

    private void printResult(final LottoResult lottoResult) {
        output.printStatistics(lottoResult);
        output.printYield(lottoResult.calculateYield());
    }
}
