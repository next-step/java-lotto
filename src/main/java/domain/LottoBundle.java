package domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoBundle {
    private final List<Lotto> lottoList;
    private final WinningNumbers winningNumbers;

    public LottoBundle(List<Lotto> lottoList, WinningNumbers winningNumbers) {
        this.lottoList = lottoList;
        this.winningNumbers = winningNumbers;
    }

    public LottoStatistics toLottoStatics() {
        return new LottoStatistics(getRanks(), this.lottoList.size());
    }

    public List<Rank> getRanks() {
        return lottoList.stream()
            .map(lotto -> lotto.rankOf(winningNumbers))
            .collect(Collectors.toList());
    }
}
