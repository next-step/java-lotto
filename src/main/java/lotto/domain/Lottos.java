package lotto.domain;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Lottos implements Iterable<Lotto> {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Stream<Lotto> stream() {
        Iterator<Lotto> iterator = this.lottos.iterator();

        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false);
    }

    public Lottos merge(Lottos inputLottos) {
        List<Lotto> mergedLottoList = new ArrayList<>(this.lottos);
        mergedLottoList.addAll(inputLottos.lottos);
        return new Lottos(mergedLottoList);
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
