package step2.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import step2.statistics.DefaultLottoStatistics;

public class Lottos {
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
        final Map<Integer, List<Lotto>> collect = Stream.of(3, 4, 5, 6)
                                                        .collect(Collectors.toMap(i -> i,
                                                                                  i -> get(winNumbers, i),
                                                                                  (a, b) -> {
                                                                                      final List<Lotto> objects = new ArrayList<>();
                                                                                      objects.addAll(a);
                                                                                      objects.addAll(b);
                                                                                      return objects;
                                                                                  }));

        return new DefaultLottoStatistics(collect);

    }

    private List<Lotto> get(final List<Integer> winNumbers, final int boundInclusive) {
        final List<Lotto> collect = lottos.stream()
                                          .filter(lotto -> lotto.matches(winNumbers, boundInclusive))
                                          .collect(Collectors.toList());

        return collect;

    }

    @Override
    public String toString() {
        return lottos.stream()
                     .map(Object::toString)
                     .collect(Collectors.joining("\n"));
    }
}
