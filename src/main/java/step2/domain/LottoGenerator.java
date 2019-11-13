package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        List<LottoNum> selectedNums;

        selectedNums = addRandomNumber();

        Collections.sort(selectedNums);
        return selectedNums;
    }

    public static List<LottoNum> makeNumbers(List<Integer> lottoNums) {
        List<LottoNum> selectedNums = new ArrayList<>();

        for (int inputLottoNum : lottoNums) {
            selectedNums.add(new LottoNum(inputLottoNum));
        }

        Collections.sort(selectedNums);
        return selectedNums;
    }

    private static void shuffle() {
        Collections.shuffle(candidate);
    }

    private static List<LottoNum> addRandomNumber() {
        List<LottoNum> selectedNums = new ArrayList<>();

        for (int i = 0; i < LOTTO_SIZE; i++) {
            selectedNums.add(new LottoNum(candidate.get(i)));
        }
        return selectedNums;
    }
}
