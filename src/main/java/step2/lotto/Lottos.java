package step2.lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import step2.statistics.DefaultLottoStatistics;

public class Lottos {
    public static final Lottos EMTPY = new Lottos(Collections.EMPTY_LIST);
    public static final List<Integer> MATCH_NUMBER_COUNT_TO_WIN = Collections.unmodifiableList(
            Arrays.asList(3, 4, 5, 6));

    private final List<Lotto> lottos;

    public Lottos(final Lotto... lottos) {
        this(Arrays.asList(lottos));
    }

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int countMatchesLotto(final List<Integer> winNumbers) {
        return (int) lottos.stream()
                           .filter(lotto -> lotto.matchesAll(winNumbers))
                           .count();
    }

    public DefaultLottoStatistics stats(final List<Integer> winNumbers) {
        final Map<Integer, Lottos> collect = MATCH_NUMBER_COUNT_TO_WIN
                .stream()
                .collect(Collectors.toMap(i -> i,
                                          i -> filterByMatchCount(winNumbers, i)));

        return new DefaultLottoStatistics(collect);

    }

    public int size() {
        return lottos.size();
    }

    private Lottos filterByMatchCount(final List<Integer> winNumbers, final int boundInclusive) {
        return new Lottos(lottos.stream()
                                .filter(lotto -> lotto.matches(winNumbers, boundInclusive))
                                .collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return lottos.stream()
                     .map(Object::toString)
                     .collect(Collectors.joining("\n"));
    }

    public long priceSum() {
        return lottos.stream().map(Lotto::getPrice).mapToLong(Integer::longValue).sum();
    }
}
