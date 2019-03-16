package lotto.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NUMBER_OF_LOTTO_NUMBERS = 6;

    private LottoGenerator() {
    }

    public static Lotto generate() {
        return new Lotto(getSortedLottoNumbers());
    }

    private static List<Integer> getSortedLottoNumbers() {
        List<Integer> lottoNumbers = getUnsortedLottoNumbers();
        sort(lottoNumbers);
        return lottoNumbers;
    }

    private static void sort(List<Integer> lottoNumbers) {
        lottoNumbers.sort(Comparator.naturalOrder());
    }


    private static List<Integer> getUnsortedLottoNumbers() {
        return getShuffledAllLottoNumbers().subList(0, NUMBER_OF_LOTTO_NUMBERS);
    }

    static List<Integer> getAllLottoNumbers() {
        return IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    private static List<Integer> getShuffledAllLottoNumbers() {
        List<Integer> allLottoNumbers = getAllLottoNumbers();
        Collections.shuffle(allLottoNumbers);

        return allLottoNumbers;
    }

}
