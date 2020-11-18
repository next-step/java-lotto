package step02.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    private Map<Integer, Integer> calculateCountNumber(Lotto winningNumbers) {
        Map<Integer, Integer> map = new HashMap<>();
        lottos.stream().forEach(lotto -> {
            int count = lotto.matchCount(winningNumbers);
            map.put(count, map.getOrDefault(count, 0) + 1);
        });

        return map;
    }

    public NumberCountCollections statisticWinning(Lotto winningNumbers) {
        List<NumberCount> numberCounts = calculateCountNumber(winningNumbers).entrySet()
                .stream()
                .map(entry -> NumberCount.of(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        return NumberCountCollections.of(numberCounts);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

}
