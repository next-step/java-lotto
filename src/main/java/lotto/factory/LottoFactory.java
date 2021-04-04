package lotto.factory;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoFactory {

    public static List<Lotto> buyManualLottos(List<Set<Integer>> manualLottoNumbers, Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < manualLottoNumbers.size(); i++) {
            lottos.add(Lotto.from(manualLottoNumbers.get(i)));
            money.buyLotto();
        }
        return lottos;
    }

    public static List<Lotto> buyAutoLottos(NumberGenerator numberGenerator, Money money) {
        List<Lotto> lottos = new ArrayList<>();
        while (money.isPossibleBuyLotto()) {
            lottos.add(Lotto.from(numberGenerator));
            money.buyLotto();
        }
        return lottos;
    }
}
