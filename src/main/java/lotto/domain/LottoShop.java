package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private static final int LOTTO_PRICE = 1_000;

    public Lottos purchase(LottoPrice lottoPrice, LottoMachine machine) {
        int quantity = lottoPrice.getPurchasePrice() / LOTTO_PRICE;
        return createLotto(quantity, machine);
    }

    private Lottos createLotto(int quantity, LottoMachine machine) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(new LottoNumbers(machine)));
        }

        return new Lottos(lottos);
    }
}