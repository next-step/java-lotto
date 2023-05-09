package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return List.copyOf(lottoList);
    }

    public int getLottoQuantity() {
        return lottoList.size();
    }

    public static Lottos concat(Lottos... lottos) {
        return new Lottos(Stream.of(lottos)
                .flatMap(l -> l.getLottoList().stream())
                .collect(Collectors.toList()));
    }
}
