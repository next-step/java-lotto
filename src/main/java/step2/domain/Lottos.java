package step2.domain;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class Lottos {
    private List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public LottoResult winningResult(WinningLottoNumbers winningLotto) {
        return lottoList.stream()
                .map(winningLotto::getWinningRank)
                .collect(collectingAndThen(groupingBy(Function.identity(), counting()), LottoResult::of));
    }

}
