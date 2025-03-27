package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoList {
    private final List<Lotto> lottoList;

    public LottoList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }


    public List<Rank> getResult(WinningLotto winningLotto) {
        return lottoList.stream()
                .map(lotto -> lotto.getRank(winningLotto))
                .collect(Collectors.toList());
    }
}
