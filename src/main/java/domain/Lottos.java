package domain;

import util.WinType;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottos;

    Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    List<Lotto> getLottos() {
        return lottos;
    }

    int size() {
        return lottos.size();
    }

    LottoResult lottery(int money, Lotto answer) {
        Map<WinType, Long> map = lottos.stream()
                .map(it -> it.lottery(answer))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return new LottoResult(money, map);
    }
}
