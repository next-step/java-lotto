package lotto.domain;

import java.util.*;

public class LottoGenerator {

    private static final List<Integer> LOTTO_ELEMENTS = new ArrayList<>();

    static {
        for (int i = 1; i <= 65; i++) {
            LOTTO_ELEMENTS.add(i);
        }
    }

    public Lotto generate() {
        return new Lotto(shuffle());
    }

    private List<Integer> shuffle(){
        Collections.shuffle(LOTTO_ELEMENTS);
        List<Integer> drawnElements = LOTTO_ELEMENTS.subList(0, 6);
        Collections.sort(drawnElements);
        return drawnElements;
    }
}
