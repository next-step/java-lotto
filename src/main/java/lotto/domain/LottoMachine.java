package lotto.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoMachine {

    public static Lottos createLottos(List<Set<Integer>> manualNumbersList, Money money) {
        List<Lotto> manualLottos = manualNumbersList.stream()
                .map(Lotto::createManualLotto)
                .collect(Collectors.toList());
        Lottos lottos = new Lottos(manualLottos);

        List<Lotto> autoLottos = Lottos.of(money).getLottos();
        lottos.addLottoList(autoLottos);
        return lottos;
    }
}
