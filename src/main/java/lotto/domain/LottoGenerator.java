package lotto.domain;

import java.util.*;

public class LottoGenerator {

    private static final ArrayList<Integer> LOTTO_ELEMENTS = new ArrayList<>();

    private static final int MIN_LOTTO_ELEMENT = 1;
    private static final int MAX_LOTTO_ELEMENT = 65;

    static {
        for (int i = MIN_LOTTO_ELEMENT; i <= MAX_LOTTO_ELEMENT; i++) {
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
