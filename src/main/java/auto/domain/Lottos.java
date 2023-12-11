package auto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static Lottos createLottoNumbersList(int lottoCount) {
        return new Lottos(IntStream.range(0, lottoCount)
                                   .mapToObj(i -> Lotto.createLottoNumbers())
                                   .collect(Collectors.toCollection(ArrayList::new)));
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
