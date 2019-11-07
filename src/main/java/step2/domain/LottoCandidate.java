package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoCandidate {
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
        for (int i = 0; i < LottoTicket.LOTTO_SIZE; i++) {
            selectedNums.add(candidate.get(i));
        }
    }
}
