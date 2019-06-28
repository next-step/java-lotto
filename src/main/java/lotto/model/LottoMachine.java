package lotto.model;

import lotto.model.generator.LottoGenerator;
import lotto.model.generator.ManualLottoGenerator;
import lotto.model.generator.RandomLottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static LottoTicket buy(Money money, List<String> numbersOfManual) {
        List<Lotto> lottos = new ArrayList<>();
        if (!(numbersOfManual == null || numbersOfManual.isEmpty())) {
            lottos.addAll(buyManualLotto(numbersOfManual));
            money = money.spendOnLotto(numbersOfManual.size());
        }
        if (money.hasBuyLotto()) {
            lottos.addAll(buyRandomLotto(money));
        }
        return LottoTicket.of(lottos);
    }

    private static List<Lotto> buyManualLotto(List<String> numbersOfManual) {
        LottoGenerator manualLottoGenerator = new ManualLottoGenerator(numbersOfManual);
        return manualLottoGenerator.generator();
    }

    private static List<Lotto> buyRandomLotto(Money money) {
        LottoGenerator randomLottoGenerator = new RandomLottoGenerator(money);
        return randomLottoGenerator.generator();
    }
}
