package step2.domain;

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

    public Lottos(List<Lotto> lottoList) {
        this.lottos = lottoList;
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

    public int getTotal() {
        return size() * Lotto.getLottoPrice();
    }

    public Map<Lotto, Integer> getAllMatchCount(LottoNumbers target) {
        Map<Lotto, Integer> matchCountMap = new HashMap<>();
        for (Lotto lotto : lottos) {
            int matchCount = lotto.getMatchCount(target);
            matchCountMap.put(lotto, matchCount);
        }
        return matchCountMap;
    }

    public String getAllLottoNumbers() {
        return lottos.stream()
            .map(Lotto::getLottoNumbers)
            .collect(Collectors.joining("\n"));
    }
}
