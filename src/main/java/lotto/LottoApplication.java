package lotto;

import java.util.List;
import lotto.domain.LottoManager;
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
        Money purchaseAmount = new Money(inputPurchaseAmount());
        output.printAmount(purchaseAmount.calculateQuantity(new Money(1000L)));
        LottoManager manager = LottoManager.createLottoManagerByMoney(purchaseAmount);

        output.printLottos(manager);
        System.out.println();

        WinningLotto winningLotto = inputWinningLotto();
        result(manager, winningLotto);
    }

    private Long inputPurchaseAmount() {
        output.printAskPurchaseAmount();
        return input.inputPurchaseAmount();
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

    private void result(LottoManager manager, WinningLotto winningLotto) {
        output.printStatistics(manager.getResult(winningLotto));
        output.printYield(manager.calculateYield(winningLotto));
    }
}
