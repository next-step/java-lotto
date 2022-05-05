package lotto.domain;

import lotto.pattern.LottoNumberGenerateStrategy;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGroup {
    private static final int NO_COUNT = 0;
    private static final int UNIT_COUNT = 1;

    private final List<Lotto> lottos;

    public LottoGroup(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoGroup(int lottoCount, LottoNumberGenerateStrategy lottoNumberGenerateStrategy) {
        this.lottos = IntStream.range(0, lottoCount).mapToObj(i -> new Lotto(lottoNumberGenerateStrategy)).collect(Collectors.toList());
    }

    public LottoGroupResult getLottoGroupResult(Lotto winningLotto) {
        final Map<Rank, Integer> lottoGroupResult = new EnumMap<>(Rank.class);
        for (Lotto lotto : this.lottos) {
            Rank rank = lotto.getRank(winningLotto);
            lottoGroupResult.put(rank, lottoGroupResult.getOrDefault(rank, NO_COUNT) + UNIT_COUNT);
        }
        return new LottoGroupResult(lottoGroupResult);
    }

    public List<List<Integer>> getLottoGroupNumber() {
        return lottos.stream().map(Lotto::getNumbers).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoGroup that = (LottoGroup) o;

        return Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return lottos != null ? lottos.hashCode() : 0;
    }
}
