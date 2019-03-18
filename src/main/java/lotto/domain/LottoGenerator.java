package lotto.domain;

import lotto.domain.ticket.Lotto;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private LottoGenerator() {
    }

    public static Lotto generate() {
        List<Integer> unsortedLottoNumbers = getUnsortedLottoNumbers();

        List<Integer> lottoNumbers = extractSortedLottoNumbers(unsortedLottoNumbers);
        int bonusNumber = unsortedLottoNumbers.get(Lotto.LOTTO_NUMBERS_SIZE);

        return new Lotto(lottoNumbers, bonusNumber);
    }

    private static List<Integer> extractSortedLottoNumbers(List<Integer> unsortedLottoNumbers) {
        List<Integer> sortedLottoNumbers = unsortedLottoNumbers.subList(0, Lotto.LOTTO_NUMBERS_SIZE);
        sort(sortedLottoNumbers);

        return sortedLottoNumbers;
    }

    private static void sort(List<Integer> lottoNumbers) {
        lottoNumbers.sort(Comparator.naturalOrder());
    }

    private static List<Integer> getUnsortedLottoNumbers() {
        return getShuffledAllLottoNumbers().subList(0, Lotto.LOTTO_NUMBERS_SIZE + 1);
    }

    static List<Integer> getAllLottoNumbers() {
        return IntStream.rangeClosed(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    private static List<Integer> getShuffledAllLottoNumbers() {
        List<Integer> allLottoNumbers = getAllLottoNumbers();
        Collections.shuffle(allLottoNumbers);

        return allLottoNumbers;
    }
}
