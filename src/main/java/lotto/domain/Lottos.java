package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos = new ArrayList<>();

    public Lottos(PurchaseLotto purchaseLotto) {
        createAutoLottos(purchaseLotto);
    }

    private void createAutoLottos(PurchaseLotto purchaseLotto) {
        for (int i = 0; i < purchaseLotto.getAmount(); i++) {
            lottos.add(new Lotto(LottoFactory.createAutoLottoNumbers()));
        }
    }

    @Override
    public String toString() {
        return lottos.stream().map(lotto -> lotto.toString() + "\n").collect(Collectors.joining());
    }
}
