package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNum.MAX;
import static lotto.domain.LottoNum.MIN;

public class LottoGenerator {
    public static final int LOTTO_SIZE = 6;
    private static final int START_INDEX = 0;

    private static List<Integer> candidate = new ArrayList<>();

    static {
        makeCandidateNumbers();
    }

    private static void makeCandidateNumbers() {
        for (int i = MIN; i <= MAX; i++) {
            candidate.add(i);
        }
    }

    public static List<Integer> makeAutoNumbers() {
        shuffle();

        return getRandomNumbers();
    }

    public static Set<LottoNum> makeNumbers(List<Integer> lottoNums) {
        return lottoNums.stream()
                .map(LottoNum::new)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    private static void shuffle() {
        Collections.shuffle(candidate);
    }

    private static List<Integer> getRandomNumbers() {
        return IntStream.range(START_INDEX, LOTTO_SIZE)
                .mapToObj(i -> candidate.get(i))
                .collect(Collectors.toList());
    }
}
