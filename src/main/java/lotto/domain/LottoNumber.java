package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NavigableSet;

import static java.util.Collections.shuffle;

public class LottoNumber {

    private final static int COUNT_OF_LOTTO_NUMBER = 6;
    private final static int MIN_LOTTO_NUMBER = 1;
    private final static int MAX_LOTTO_NUMBER = 45;
    private final static List<Integer> LOTTO_NUMBERS = Arrays.asList(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45
    );

    private LottoNumber() {
    }

    public static List<Integer> shuffleNumbers() {
        shuffle(LOTTO_NUMBERS);
        return Collections.unmodifiableList(LOTTO_NUMBERS);
    }

    public static boolean validateLottoNumber(NavigableSet<Integer> lottoNumber) {
        if (lottoNumber == null) {
            throw new IllegalArgumentException("로또 번호를 전달 받지 못하였습니다.");
        }
        return lottoNumber.headSet(MAX_LOTTO_NUMBER, true).size() == COUNT_OF_LOTTO_NUMBER
                && lottoNumber.tailSet(MIN_LOTTO_NUMBER, true).size() == COUNT_OF_LOTTO_NUMBER
                && lottoNumber.subSet(MIN_LOTTO_NUMBER, true, MAX_LOTTO_NUMBER, true).size() == COUNT_OF_LOTTO_NUMBER;
    }

    public static boolean validateLottoNumber(List<NavigableSet<Integer>> lottoTickets) {
        if (lottoTickets == null || lottoTickets.size() < 1) {
            throw new IllegalArgumentException("로또 번호를 전달 받지 못하였습니다.");
        }
        return lottoTickets.stream()
                .allMatch(LottoNumber::validateLottoNumber);
    }
}
