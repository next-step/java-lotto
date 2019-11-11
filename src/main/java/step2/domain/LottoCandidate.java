package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static step2.domain.LottoTicket.LOTTO_NUM_MAX;
import static step2.domain.LottoTicket.LOTTO_NUM_MIN;

public class LottoCandidate {
    public static final int LOTTO_SIZE = 6;

    private static List<Integer> candidate = new ArrayList<>();

    static {
         makeCandidateNumbers();
    }

    public LottoCandidate() {

    }

    public static void makeCandidateNumbers() {
        for (int i = LOTTO_NUM_MIN; i <= LOTTO_NUM_MAX; i++) {
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
