package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoManager;
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
        output.printAskPurchaseAmount();
        int purchaseAmount = input.inputPurchaseAmount();
        output.printAmount(purchaseAmount / 1000);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount / 1000; i++) {
            lottos.add(Lotto.createRandomLotto());
        }
        LottoManager manager = new LottoManager(lottos);

        output.printLottos(lottos);
        System.out.println();
        output.printAskWinningNumbers();
        List<Integer> winningNumbers = input.inputWinningNumbers();
        output.printAskBonus();
        int bonus = input.inputBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonus);
        System.out.println();

        output.printStatistics(manager.getResult(winningLotto));
        output.printYield(manager.calculateYield(winningLotto));
    }
}
