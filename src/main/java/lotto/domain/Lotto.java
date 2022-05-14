package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int LOTTO_LENGTH = 6;
    private static final int MAX_VALUE = 45;

    private final List<Integer> selectedNumbers;

    public Lotto() {
        List<Integer> candidateNumbers = candidateNumbers();

        Collections.shuffle(candidateNumbers);
        this.selectedNumbers = candidateNumbers.subList(0, LOTTO_LENGTH);
        Collections.sort(this.selectedNumbers);
    }

    public Lotto(Integer[] lottoByHand) {
        this.selectedNumbers = Arrays.asList(lottoByHand);
    }

    public Lotto(String[] lottoByHand) {
        this.selectedNumbers = parseStringArrayToIntegerArray(lottoByHand);
    }

    private List<Integer> candidateNumbers() {
        List<Integer> candidateNumbers = new ArrayList<>();
        for (int number = 1; number <= MAX_VALUE; number++) {
            candidateNumbers.add(number);
        }
        return candidateNumbers;
    }

    public List<Integer> selectedNumbers() {
        return Collections.unmodifiableList(selectedNumbers);
    }

    private List<Integer> parseStringArrayToIntegerArray(String[] stringInputs) {
        List<Integer> integers = new ArrayList<>();

        for (String input : stringInputs) {
            integers.add(Integer.parseInt(input));
        }
        return integers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lotto lotto = (Lotto) o;

        return selectedNumbers != null ? selectedNumbers.equals(lotto.selectedNumbers) : lotto.selectedNumbers == null;
    }

    @Override
    public int hashCode() {
        return selectedNumbers != null ? selectedNumbers.hashCode() : 0;
    }
}
