package model;

import java.util.*;

public class Lottos {
    private final List<Lotto> list;

    public Lottos(List<Lotto> lottos) {
        this.list = lottos;
    }

    public Map<Integer, Integer> placementCounts(Lotto winningLotto) {
        Map<Integer, Integer> pc = new HashMap<>();
        for (Lotto lotto : list) {
            int matchingCount = LottoMatcher.count(lotto, winningLotto);
            pc.put(matchingCount, pc.getOrDefault(matchingCount, 0) + 1);
        }
        return pc;
    }

    public LottoResult rankCounts(Lotto winningLotto, Integer bonusNumber, Integer lottoPrice) {
        Map<Rank, Integer> map = new EnumMap<>(Rank.class);
        for (Lotto lotto : list) {
            LottoMatch match = LottoMatcher.match(lotto, winningLotto, bonusNumber);
            Rank rank = Rank.valueOf(match);
            map.put(rank, map.getOrDefault(rank, 0) + 1);
        }
        return new LottoResult(lottoPrice, map);
    }

    public int count() {
        return list.size();
    }

    public Lotto get(int index) {
        return list.get(index);
    }
}