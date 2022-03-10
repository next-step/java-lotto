package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> handLottos, List<Lotto> automaticLottos) {
        lottos = Stream.concat(handLottos.stream(), automaticLottos.stream()).collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
