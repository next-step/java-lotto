package lotto;

import java.util.*;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    Set<Integer> lottoNumbers;

    private Lotto(Set<Integer> lottoNumbers) {
        this.lottoNumbers = Collections.unmodifiableSet(lottoNumbers);
    }

    public static Lotto of(Set<Integer> lottoNumbers) {
        checkSize(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    public static Lotto ofComma(String stringNumbers) {
        String[] splitNumbers = stringNumbers.split(",");
        Set<String> numbers = new HashSet<>();
        Collections.addAll(numbers, splitNumbers);

        Set<Integer> lottoNumbers = new HashSet<>();
        for (String number : numbers) {
            lottoNumbers.add(Integer.parseInt(number));
        }
        return of(lottoNumbers);
    }

    private static void checkSize(Set<Integer> splitNumbers) {
        if (splitNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("invalid lotto size");
        }
    }

}
