package lotto.domain;

import java.util.*;

public class RandomLottoNumbers {
    private static List<Integer> LOTTO_NUMBERS = new ArrayList<>();
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int SIZE = 6;

    static {
        for (int i = MIN; i <= MAX; i++) {
            LOTTO_NUMBERS.add(i);
        }
    }

    public LottoTicket generateNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);

        List<Integer> randomLottoNumbers = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            randomLottoNumbers.add(LOTTO_NUMBERS.get(i));
        }
        return new LottoTicket(randomLottoNumbers);
    }
}
