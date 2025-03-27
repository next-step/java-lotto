package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoList {
    private final List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public LottoResult getLottoResult(WinningLotto winningLotto) {
        List<Rank> rankList = lottoList.stream()
                .map(lotto -> lotto.getRank(winningLotto))
                .collect(Collectors.toList());
        return new LottoResult(rankList);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
