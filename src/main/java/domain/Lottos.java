package domain;

import util.RandomUtils;
import util.WinType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static util.Constants.PRICE_OF_LOTTO;

public class Lottos {
    private List<Lotto> lottos;

    Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    static Lottos createLottos(int money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / PRICE_OF_LOTTO; i++) {
            lottos.add(Lotto.of(RandomUtils.createNumbers()));
        }

        return new Lottos(lottos);
    }

    List<Lotto> getLottos() {
        return lottos;
    }

    Map<WinType, Long> figure(WinningLotto winningLotto) {
        return lottos.stream()
                .map(it -> winningLotto.figure(it))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
