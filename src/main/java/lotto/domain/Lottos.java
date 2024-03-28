package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Lottos implements Iterable<Lotto> {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }

    public Lottos merge(Lottos inputLottos) {
        List<Lotto> mergedLottoList = new ArrayList<>(this.lottos);
        mergedLottoList.addAll(inputLottos.lottos);
        return new Lottos(mergedLottoList);
    }
}
