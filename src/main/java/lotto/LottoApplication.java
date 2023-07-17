package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.domain.vo.LottoNumber;
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
        Quantity manualLottoQuantity = inputManualLottoCount(purchaseMoney);
        Quantity randomLottoQuantity = LottoGroup.calculateRandomLottoQuantity(purchaseMoney,
            manualLottoQuantity);
        LottoGroup lottoGroup = LottoGroup.createRandomAndManualLottos(randomLottoQuantity,
            inputManualLotto(manualLottoQuantity));

        output.printQuantity(manualLottoQuantity, randomLottoQuantity);
        output.printLottos(lottoGroup);
        printResult(LottoResult.of(lottoGroup, inputWinningLotto()));
    }

    private Money inputPurchaseMoney() {
        Money purchaseMoney = new Money(input.inputPurchaseMoney());
        LottoGroup.verify(purchaseMoney);
        return purchaseMoney;
    }

    private Quantity inputManualLottoCount(Money available) {
        Quantity quantity = new Quantity(input.inputManualLottoQuantity());
        if (!LottoGroup.canBuy(available, quantity)) {
            throw new IllegalArgumentException("not enough money");
        }
        return quantity;
    }

    private List<List<Integer>> inputManualLotto(Quantity quantity) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> manualLottos = new ArrayList<>();
        for (int i = 0; i < quantity.getValue(); i++) {
            manualLottos.add(input.inputManualLottoNumbers());
        }
        System.out.println();
        return manualLottos;
    }

    private WinningLotto inputWinningLotto() {
        Lotto winningLottos = Lotto.createSpecificLotto(input.inputWinningNumbers());
        int bonus = input.inputBonusNumber();
        return new WinningLotto(winningLottos, LottoNumber.of(bonus));
    }

    private void printResult(final LottoResult lottoResult) {
        output.printStatistics(lottoResult);
        output.printProfit(lottoResult.calculateProfit());
    }
}
