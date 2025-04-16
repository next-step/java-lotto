package step3.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 로또 묶음
 */
public class Lottos {
    private final List<Lotto> lottos;
    // private final Map<Lotto, MatchResult> result = new HashMap<>();

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(int count) {
        lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
    }

    public int size() {
        return lottos.size();
    }

    public int calculateTotal() {
        return size() * Lotto.getLottoPrice();
    }

    public Map<Lotto, Integer> matchCountMap(LottoNumbers target) {
        Map<Lotto, Integer> matchCountMap = new HashMap<>();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.matchCount(target);
            matchCountMap.put(lotto, matchCount);
        }
        return matchCountMap;
    }

    public String allLottoNumbersToString() {
        return lottos.stream()
            .map(Lotto::numbersToString)
            .collect(Collectors.joining("\n"));
    }
}
