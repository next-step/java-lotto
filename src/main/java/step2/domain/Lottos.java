package step2.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createByNumbers(final List<List<Integer>> lottosNumbers) {
        return new Lottos(lottosNumbers.stream()
                                       .map(Lotto::convertNumbersToLotto)
                                       .collect(Collectors.toList()));
    }

    public Lottos appendLottos(Lottos lottos) {
        List<Lotto> mergedLottos = getLottos();
        mergedLottos.addAll(lottos.lottos);
        return new Lottos(mergedLottos);
    }

    public List<Lotto> getLottos() {
        return this.lottos.stream()
                          .map(Lotto::new)
                          .collect(Collectors.toList());
    }

    public int size() {
        return this.lottos.size();
    }

    public boolean isEmpty() {
        return this.lottos.isEmpty();
    }
}
