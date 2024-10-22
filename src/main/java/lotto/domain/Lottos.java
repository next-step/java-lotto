package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(Lotto... lottos) {
        this(Arrays.stream(lottos).collect(Collectors.toList()));
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(Lottos... multipleLottos) {
        List<Lotto> combinedLottos = new ArrayList<>();

        for (Lottos lottos : multipleLottos) {
            combinedLottos.addAll(lottos.lottos);
        }
        return new Lottos(combinedLottos);
    }

    public int size() {
        return lottos.size();
    }

    public Lotto valueAt(int index) {
        return lottos.get(index);
    }
}
