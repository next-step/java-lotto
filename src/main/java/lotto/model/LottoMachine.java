package lotto.model;

import lotto.model.generator.*;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static LottoTicket buy(Money money, List<String> numbersOfManual) {
        List<Lotto> lottos = new ArrayList<>();
        if (!(numbersOfManual.isEmpty())) {
            lottos.addAll(buyManualLotto(numbersOfManual));
            money = money.spendOnLotto(numbersOfManual.size());
        }
        if (money.hasBuyLotto()) {
            lottos.addAll(buyRandomLotto(money));
        }
        return LottoTicket.of(lottos);
    }

    private static List<Lotto> buyManualLotto(List<String> numbersOfManual) {
        return new ManualLottoGenerator(numbersOfManual).generator();
    }

    private static List<Lotto> buyRandomLotto(Money money) {
        return new RandomLottoGenerator(money).generator();
    }
}
