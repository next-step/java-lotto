package lotto.domain;

import java.util.*;

public class LottoGenerator {

    private static final ArrayList<Integer> LOTTO_ELEMENTS = new ArrayList<>();

    static {
        for (int i = 1; i <= 65; i++) {
            LOTTO_ELEMENTS.add(i);
        }
    }

    public Lotto generate() {
        return new Lotto(shuffle());
    }

    private List<Integer> shuffle(){
        List<Integer> lottoElements = (List<Integer>) LOTTO_ELEMENTS.clone();
        Collections.shuffle(lottoElements);
        List<Integer> drawnElements = lottoElements.subList(0, 6);
        Collections.sort(drawnElements);
        return drawnElements;
    }
}
