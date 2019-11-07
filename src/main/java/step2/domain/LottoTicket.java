package step2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private static final int LOTTO_NUM_MIN = 1;
    private static final int LOTTO_NUM_MAX = 45;

    private final List<Integer> lottoNums;

    public LottoTicket() {
        this.lottoNums = makeAutoNumbers();
        checkNumsRange();
    }

    public List<Integer> makeAutoNumbers() {
        List<Integer> candidateNumbers = new ArrayList<>();
        makeCandidateNumbers(candidateNumbers);

        List<Integer> selectedNums = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            selectedNums.add(candidateNumbers.get(i));
        }

        Collections.sort(selectedNums);

        return selectedNums;
    }

    private void makeCandidateNumbers(List<Integer> candidateNumbers) {
        for (int i = 1; i <= 45; i++) {
            candidateNumbers.add(i);
        }

        Collections.shuffle(candidateNumbers);
    }

    private void checkNumsRange() {
        for (int lottoNum : lottoNums) {
            checkNumRange(lottoNum);
        }
    }

    private void checkNumRange(int lottoNum) {
        if (!isProperNumRange(lottoNum)) {
            throw new IllegalArgumentException("Out of range");
        }
    }

    private boolean isProperNumRange(int lottoNum) {
        return (lottoNum >= LOTTO_NUM_MIN && lottoNum <= LOTTO_NUM_MAX);
    }

    public List<Integer> getLottoNums() {
        return this.lottoNums;
    }
}
