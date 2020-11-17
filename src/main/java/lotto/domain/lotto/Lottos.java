package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    public static Lottos EMPTY = Lottos.of(Collections.emptyList());
    private final List<Lotto> lottoList;

    private Lottos(final List<Lotto> lottoList) {
        this.lottoList = Collections.unmodifiableList(lottoList);
    }

    public static Lottos of(final List<Lotto> lottos) {
        if (lottos == null) {
            return EMPTY;
        }
        return new Lottos(lottos);
    }

    public int size() {
        return lottoList.size();
    }

    public List<Lotto> get() {
        return lottoList;
    }

    public List<List<Integer>> getAllLottoNumber() {
        return lottoList.stream().map(Lotto::getLottoNumber).collect(Collectors.toList());
    }
}
