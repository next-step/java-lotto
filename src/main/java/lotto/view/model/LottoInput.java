package lotto.view.model;

import lotto.domain.model.Lotto;
import lotto.domain.model.Money;

import java.util.ArrayList;
import java.util.List;

public class LottoInput {
    private final Money purchaseAmount;
    private final List<Lotto> manualLottos;

    private LottoInput(Money purchaseAmount, List<Lotto> manualLottos) {
        this.purchaseAmount = purchaseAmount;
        this.manualLottos = manualLottos;
    }

    public static LottoInput from(int purchaseAmount, List<List<Integer>> manualNums) {
        List<Lotto> manualLottos = new ArrayList<>();
        for (List<Integer> manualNum : manualNums) {
            manualLottos.add(Lotto.createManual(manualNum));
        }
        return new LottoInput(new Money(purchaseAmount), manualLottos);
    }

    public int getPurchasedAmount() {
        return purchaseAmount.getAmount();
    }

    public List<Lotto> getManualLottos() {
        return manualLottos;
    }
}
