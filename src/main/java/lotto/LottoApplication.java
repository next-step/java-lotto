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
        Money purchaseMoney = inputPurchaseMoney();
        LottoGroup autoLottoGroup = LottoGroup.from(purchaseMoney);

        int manualQuantity = inputManualQuantity();
        int autoQuantity = purchaseMoney.calculateQuantity(new Money(LottoGroup.LOTTO_PRICE)) - manualQuantity;

        LottoGroup manualLottoGroup = inputManualLottos(manualQuantity);

        output.printQuantity(manualQuantity, autoQuantity);

        output.printLottos(autoLottoGroup);
        output.printSectionDivider();

        LottoGroup totalLottoGroup = manualLottoGroup.merge(autoLottoGroup);
        WinningLotto winningLotto = inputWinningLotto();
        output.printSectionDivider();

        printResult(LottoResult.of(totalLottoGroup, winningLotto));
    }

    private int inputManualQuantity() {
        output.printAskManualQuantity();
        int manualQuantity = input.inputManualQuantity();
        output.printSectionDivider();

        return manualQuantity;
    }

    private LottoGroup inputManualLottos(int manualQuantity) {
        output.printAskManualLottonumbers();
        List<Lotto> manualLottos = new ArrayList<>();

        for (int i = 0; i < manualQuantity; i++) {
            manualLottos.add(Lotto.createSpecificLotto(input.inputLottoNumbers()));
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
