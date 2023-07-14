package lotto;

import lotto.domain.*;
import lotto.input.LottoInput;
import lotto.output.LottoOutput;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    private final LottoInput input;
    private final LottoOutput output;

    public LottoApplication() {
        this.input = new LottoInput();
        this.output = new LottoOutput();
    }

    public void run() {
        Quantity totalLottoQuantity = Quantity.of(inputPurchaseMoney(), LottoGroup.LOTTO_PRICE);
        Quantity manualLottoQuantity = inputManualQuantity();
        Quantity autoLottoQuantity = totalLottoQuantity.subtract(manualLottoQuantity);

        LottoGroup autoLottoGroup = LottoGroup.from(autoLottoQuantity);
        LottoGroup manualLottoGroup = inputManualLottos(manualLottoQuantity);

        output.printQuantity(manualLottoQuantity, autoLottoQuantity);
        output.printLottos(autoLottoGroup);
        output.printSectionDivider();

        LottoGroup totalLottoGroup = manualLottoGroup.merge(autoLottoGroup);
        WinningLotto winningLotto = inputWinningLotto();
        output.printSectionDivider();

        printResult(LottoResult.of(totalLottoGroup, winningLotto));
    }

    private Quantity inputManualQuantity() {
        output.printAskManualQuantity();
        int manualQuantity = input.inputManualQuantity();
        output.printSectionDivider();

        return new Quantity(manualQuantity);
    }

    private LottoGroup inputManualLottos(final Quantity manualQuantity) {
        output.printAskManualLottonumbers();
        List<Lotto> manualLottos = new ArrayList<>();

        for (int i = 0; i < manualQuantity.getQuantity(); i++) {
            manualLottos.add(Lotto.createManualLotto(input.inputLottoNumbers()));
        }

        output.printSectionDivider();

        return new LottoGroup(manualLottos);
    }

    private Money inputPurchaseMoney() {
        output.printAskPurchaseMoney();
        Money purchaseMoney = new Money(input.inputPurchaseMoney());
        output.printSectionDivider();
        return purchaseMoney;
    }

    private WinningLotto inputWinningLotto() {
        output.printAskWinningNumbers();
        List<Integer> winningNumbers = input.inputLottoNumbers();
        output.printAskBonus();
        int bonus = input.inputBonusNumber();

        return new WinningLotto(winningNumbers, bonus);
    }

    private void printResult(final LottoResult lottoResult) {
        output.printStatistics(lottoResult);
        output.printYield(lottoResult.calculateYield());
    }
}
