package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static step2.domain.LottoNum.LOTTO_NUM_MAX;
import static step2.domain.LottoNum.LOTTO_NUM_MIN;

public class LottoGenerator {
    public static final int LOTTO_SIZE = 6;

    private static List<Integer> candidate = new ArrayList<>();

    static {
        makeCandidateNumbers();
    }

    private static void makeCandidateNumbers() {
        for (int i = LOTTO_NUM_MIN; i <= LOTTO_NUM_MAX; i++) {
            candidate.add(i);
        }
    }

    public static List<LottoNum> makeAutoNumbers() {
        shuffle();

        List<LottoNum> selectedNums = addRandomNumber();

        Collections.sort(selectedNums);
        return selectedNums;
    }

    public static List<LottoNum> makeNumbers(List<Integer> lottoNums) {
        return lottoNums.stream()
                .map(inputLottoNum -> new LottoNum(inputLottoNum))
                .sorted()
                .collect(Collectors.toList());
    }

    private static void shuffle() {
        Collections.shuffle(candidate);
    }

    private static List<LottoNum> addRandomNumber() {
        return IntStream.range(0, LOTTO_SIZE)
                .mapToObj(i -> new LottoNum(candidate.get(i)))
                .collect(Collectors.toList());
    }
}
