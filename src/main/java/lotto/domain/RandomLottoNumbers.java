package lotto.domain;

import java.util.*;

public class RandomLottoNumbers {
    private static List<Integer> LOTTO_NUMBERS = new ArrayList<>();
    private static final int BOUND = 45;
    private static final int SIZE = 6;

    public RandomLottoNumbers() {
        for (int i = 1; i <= BOUND; i++) {
            LOTTO_NUMBERS.add(i);
        }
    }

    public LottoTicket generateNumbers() {
        List<Integer> randomLottoNumbers = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            randomLottoNumbers.add(LOTTO_NUMBERS.get(i));
        }
        return new LottoTicket(randomLottoNumbers);
    }
}
