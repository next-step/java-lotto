package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }


    public List<String> lottoNumbersToStringList() {
        return lottos.stream()
                .map(Lotto::getLottoNumbersToStringList)
                .collect(Collectors.toList());
    }

    public LottoMatcher matchLastWeekLotto(List<Integer> lastWeekLottoNums) {
        return new LottoMatcher(lottos , lastWeekLottoNums);
    }

    public int getLottoCount() {
        return lottos.size();
    }

}
