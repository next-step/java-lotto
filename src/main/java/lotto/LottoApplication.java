package lotto;

import lotto.domain.LottoGroup;
import lotto.domain.LottoResult;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.input.LottoInput;
import lotto.output.LottoOutput;

import java.util.List;

public class LottoApplication {
    private final LottoInput input;
    private final LottoOutput output;

    public LottoApplication() {
        this.input = new LottoInput();
        this.output = new LottoOutput();
    }

    public void run() {
        Money purchaseMoney = inputPurchaseMoney();
        output.printQuantity(purchaseMoney.calculateQuantity(new Money(LottoGroup.LOTTO_PRICE)));
        LottoGroup lottoGroup = LottoGroup.from(purchaseMoney);

        output.printLottos(lottoGroup);
        output.printSectionDivider();

        WinningLotto winningLotto = inputWinningLotto();
        output.printSectionDivider();

        printResult(LottoResult.of(lottoGroup, winningLotto));
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

        return new WinningLotto(winningNumbers, bonus);
    }

    private void printResult(final LottoResult lottoResult) {
        output.printStatistics(lottoResult);
        output.printYield(lottoResult.calculateYield());
    }
}
