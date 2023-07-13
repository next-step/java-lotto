package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.domain.vo.Money;
import lotto.domain.vo.Quantity;
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
        Quantity manualLottoQuantity = inputManualLottoCount();
        Quantity randomLottoQuantity = LottoGroup.getQuantity(purchaseMoney)
            .subtract(manualLottoQuantity);

        LottoGroup lottoGroup = LottoGroup.createRandomAndManualLottos(randomLottoQuantity,
            inputManualLotto(manualLottoQuantity));
        output.printQuantity(manualLottoQuantity, randomLottoQuantity);
        output.printLottos(lottoGroup);

        WinningLotto winningLotto = inputWinningLotto();
        printResult(LottoResult.of(lottoGroup, winningLotto));
    }

    private Money inputPurchaseMoney() {
        return new Money(input.inputPurchaseMoney());
    }

    private Quantity inputManualLottoCount() {
        return new Quantity(input.inputManualLottoQuantity());
    }

    private List<Lotto> inputManualLotto(Quantity quantity) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < quantity.getValue(); i++) {
            Lotto manualLotto = Lotto.createSpecificLotto(input.inputManualLottoNumbers());
            manualLottos.add(manualLotto);
        }
        System.out.println();
        return manualLottos;
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
