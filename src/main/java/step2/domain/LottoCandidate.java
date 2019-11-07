package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoCandidate {
    public static final int LOTTO_SIZE = 6;

    private static List<Integer> candidate = new ArrayList<>();

    public LottoCandidate() {
        makeCandidateNumbers();
    }

    public static void makeCandidateNumbers() {
        for (int i = 1; i <= 45; i++) {
            candidate.add(i);
        }
    }

    public void shuffle() {
        Collections.shuffle(candidate);
    }

    public void addRandomNumber(List<Integer> selectedNums) {
        for (int i = 0; i < LOTTO_SIZE; i++) {
            selectedNums.add(candidate.get(i));
        }
    }
}
