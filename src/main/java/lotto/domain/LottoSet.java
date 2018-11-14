package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoSet {

    private List<Lotto> lottos;

    private LottoSet(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoSet create(List<Lotto> lottos) {
        return new LottoSet(lottos);
    }

    public static LottoSet create(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.create());
        }
        return new LottoSet(lottos);
    }

    public int size() {
        return lottos.size();
    }

    public List<Lotto> matchSets(List<String> target, int count) {
        return this.lottos.stream()
                .filter(lotto -> lotto.hasMatches(target, count))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
