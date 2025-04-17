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

    public Map<Lotto, MatchResult> matchResultMap(LottoNumbers target, int bonusNumber) {
        Map<Lotto, MatchResult> matchResultMap = new HashMap<>();
        for (Lotto lotto : lottos) {
            matchResultMap.put(lotto, lotto.match(target, bonusNumber));
        }
        return matchResultMap;
    }

    public String allLottoNumbersToString() {
        return lottos.stream()
            .map(Lotto::numbersToString)
            .collect(Collectors.joining("\n"));
    }
}
