package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(int lottoCount) {
        lottos = IntStream.range(0, lottoCount)
                .mapToObj(lotto -> new Lotto(getLottoNumbers()))
                .collect(Collectors.toList());
    }

    private List<Integer> getLottoNumbers() {
        return new LottoNumbers().getLottoResult();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

}
