package step2.domain;

import step2.utils.Lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    List<Lotto> lottos;

    public Lottos(int lottoCount) {
        this.lottos = Stream.generate(Lotto::new).limit(lottoCount).collect(Collectors.toList());
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoSize() {
        return this.lottos.size();
    }

    public Stream<Lotto> getLottos() {
        return this.lottos.stream();
    }
}
