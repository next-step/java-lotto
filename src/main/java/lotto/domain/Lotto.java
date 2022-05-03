package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private final int LOTTO_LENGTH = 6;
    private final int MAX_VALUE = 45;

    List<Integer> selectedNumbers;

    public Lotto() {
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

    public List<Integer> selectedNumbers() {
        return selectedNumbers;
    }
}
