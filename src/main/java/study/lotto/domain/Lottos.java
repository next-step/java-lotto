package study.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int num) {
        return Stream.generate(Lotto::auto)
                .limit(num)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public void addAll(Lottos otherLottos) {
        lottos.addAll(otherLottos.lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoResult produceLottoResult(WinningLottoInfo winningLottoInfo) {
        return LottoResult.produce(this, winningLottoInfo);
    }

    @Override
    public String toString() {
        return lottos.stream().map(Lotto::toString).collect(Collectors.joining("\n"));
    }
}
