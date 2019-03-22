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

    LottoResult figure(int money, Numbers winNumbers) {
        Map<WinType, Long> map = lottos.stream()
                .map(it -> it.figure(winNumbers))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return new LottoResult(money, map);
    }
}
