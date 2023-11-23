package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int lottoCount) {
        this.lottos = makeLottos(lottoCount);
    }

    private List<Lotto> makeLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        IntStream.range(0, lottoCount).forEach(value -> lottos.add(new Lotto()));
        return lottos;
    }

    public List<Lotto> lottos() {
        return lottos;
    }
}
