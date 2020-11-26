package step4.domain;

import java.util.*;

public class Lotto {

    private static final int QTY = 6;
    private static final int LOTTO_VALUE = 45;
    private Set<Integer> set = new HashSet<>();

    private List<Integer> lottos = new ArrayList<>();

    {
        while (QTY > set.size()) {
            set.add((int) (Math.random() * LOTTO_VALUE) + 1);
        }
    }

    public Lotto() {
        this.lottos = new ArrayList<>(set);
    }

    public List<Integer> getLottos() {
        Collections.sort(this.lottos);
        return this.lottos;
    }
}