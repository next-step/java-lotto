package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(PurchaseAmount purchaseAmount) {
        createAutoLottos(purchaseAmount);
    }

    private void createAutoLottos(PurchaseAmount purchaseAmount) {
        for (int i = 0; i < purchaseAmount.getAmount(); i++) {
            lottos.add(new Lotto(LottoFactory.createAutoLottoNumbers()));
        }
    }

    @Override
    public String toString() {
        return lottos.stream().map(lotto -> lotto.toString() + "\n").collect(Collectors.joining());
    }
}
