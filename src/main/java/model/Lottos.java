package model;

import java.util.List;

public class Lottos {
    private final List<Lotto> list;

    public Lottos(List<Lotto> lottos) {
        this.list = lottos;
    }

    public int[] placementCounts(Lotto winningLotto) {
        int[] placementCounts = new int[winningLotto.size()+1];

        for (Lotto lotto : list) {
            int matchingCount = lotto.matchingCount(winningLotto);
            placementCounts[matchingCount]++;
        }
        return placementCounts;
    }

    public int count() {
        return list.size();
    }

    public Lotto get(int index) {
        return list.get(index);
    }
}