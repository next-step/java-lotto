package lotto.domain;

import java.util.*;

public class Lotto {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;
    private static List<Integer> numbers;
    private final Set<Integer> lottoNumbers;

    static {
        numbers = new ArrayList<>();
        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            numbers.add(i);
        }
    }

    public Lotto() {
        this.lottoNumbers = createNumbers();
    }

    private Set<Integer> createNumbers() {
        Collections.shuffle(numbers);
        Set<Integer> lottoNumbers = new TreeSet<>();
        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(numbers.get(i));
        }
        return lottoNumbers;
    }

    public Set<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
