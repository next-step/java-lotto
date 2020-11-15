package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public boolean isLottoTicketsCount(int size) {
        return lottos.size() == size;
    }
    public int getLottoCount(){
        return lottos.size();
    }
    public List<String> lottoNumbersToStringList(){
        return lottos.stream()
                .map(Lotto::getLottoNumbersToStringList)
                .collect(Collectors.toList());
    }

    public LottoMatcher matchLastWeekLotto(List<Integer> lastWeekLottoNums) {
        LottoMatcher lottoMatcher = new LottoMatcher();
        lottos.stream()
                    .map(lotto -> lotto.matchLottoNumbers(lastWeekLottoNums))
                    .forEach(lottoMatcher::increaseMatchLottoCount);
        return lottoMatcher;
    }
}
