package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int LOTTO_LENGTH = 6;
    private static final int MAX_VALUE = 45;

    private final List<Integer> selectedNumbers;

    private int numberOfMatched;

    public Lotto(List<Integer> selectedNumbers) {
        this.selectedNumbers = selectedNumbers;
    }

    public Lotto() {
        this.numberOfMatched = 0;
        List<Integer> candidateNumbers = candidateNumbers();

        Collections.shuffle(candidateNumbers);
        this.selectedNumbers = candidateNumbers.subList(0, LOTTO_LENGTH);
        Collections.sort(this.selectedNumbers);
    }

    List<Integer> candidateNumbers() {
        List<Integer> candidateNumbers = new ArrayList<>();
        for (int number = 1; number <= MAX_VALUE; number++) {
            candidateNumbers.add(number);
        }
        return candidateNumbers;
    }

    void checkWinnings(Winnings winnings) {
        this.numberOfMatched = winnings.countMatchedNumbers(selectedNumbers);
    }

    public List<Integer> selectedNumbers() {
        return selectedNumbers;
    }
}
