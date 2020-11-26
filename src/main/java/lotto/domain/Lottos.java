package lotto.domain;

import lotto.service.NumberSelectionStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    public List<RankMatcher> getRankMatchers(WinningLotto winningLotto) {
        return this.lottoList.stream()
                .map(lotto -> lotto.getRankMatcher(winningLotto))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public boolean checkCount(int count) {
        return lottoList.size() == count;
    }

    public Lottos concat(Lottos lottos) {
        return new Lottos(Stream.concat(lottoList.stream(), lottos.lottoList.stream())
                .collect(Collectors.toList()));
    }
}
