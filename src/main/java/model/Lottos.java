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
            int matchingCount = lotto.matchingCount(winningLotto);
            pc.put(matchingCount, pc.getOrDefault(matchingCount, 0) + 1);
        }
        return pc;
    }
//    public List<Integer> pc(Lotto winningLotto) {
//        List<Integer> pc = new ArrayList<>();
//        for (Lotto lotto : list) {
//            int matchingCount = lotto.matchingCount(winningLotto);
//            pc.add(matchingCount);
//        }
//        return pc;
//    }

    public int count() {
        return list.size();
    }

    public Lotto get(int index) {
        return list.get(index);
    }
}