package lotto;

import java.util.List;
import lotto.domain.LottoGroup;
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
        LottoGroup lottoGroup = LottoGroup.from(purchaseMoney);
        output.printQuantity(LottoGroup.getQuantity(purchaseMoney));
        output.printLottos(lottoGroup);

        WinningLotto winningLotto = inputWinningLotto();
        printResult(LottoResult.of(lottoGroup, winningLotto));
    }

    private Money inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(input.inputPurchaseMoney());
    }

    private WinningLotto inputWinningLotto() {
        List<Integer> winningNumbers = input.inputWinningNumbers();
        int bonus = input.inputBonusNumber();
        return new WinningLotto(winningNumbers, bonus);
    }

    private void printResult(final LottoResult lottoResult) {
        output.printStatistics(lottoResult);
        output.printProfit(lottoResult.calculateProfit());
    }
}
