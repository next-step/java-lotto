package lotto.domain;

import java.util.*;

public class LottoGenerator {

    private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 65;

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            LOTTO_NUMBERS.add(i);
        }
    }

    public Lotto generate() {
        return new Lotto(shuffle());
    }

    private List<Integer> shuffle(){
        List<Integer> lottoElements = new ArrayList<>(LOTTO_NUMBERS);
        Collections.shuffle(lottoElements);
        List<Integer> drawnElements = lottoElements.subList(0, 6);
        Collections.sort(drawnElements);
        return drawnElements;
    }
}
