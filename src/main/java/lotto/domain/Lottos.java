package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(int lottoNum, NumberSelectionStrategy numberSelectionStrategy) {
        lottoList = IntStream.range(0, lottoNum)
                .mapToObj(idx -> new Lotto(numberSelectionStrategy))
                .collect(Collectors.toList());
    }

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public WinningRanks checkWinningRanks(Numbers numbers) {
        return new WinningRanks(this.lottoList.stream()
                .map(lotto -> lotto.checkWinningRank(numbers))
                .collect(Collectors.toList()));
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
