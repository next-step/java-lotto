package lotto;

import lotto.model.Lotto;
import lotto.model.LottoStore;
import lotto.view.Cashier;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Lotto> lottos = LottoStore.sell(Cashier.getMoney());
        Cashier.sayLottoCount(lottos.size());
    }
}
