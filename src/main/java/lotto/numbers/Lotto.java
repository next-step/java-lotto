package lotto.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    public static final int TOTAL_NUMBERS_SIZE = 6;

    private final List<List<Integer>> numbers; // TODO 1개의 리스트로 분리

    public Lotto(int purchaseCount) {
        this.numbers = new ArrayList<>(purchaseCount);
        generateNumbers(purchaseCount);
    }

    private void generateNumbers(int purchaseCount) {
        List<Integer> allNumbers = AllNumbers.getNumbers();
        for (int i=0 ; i<purchaseCount ; i++) {
            numbers.add(i, getNewNumbers(allNumbers));
        }
    }

    private List<Integer> getNewNumbers(List<Integer> allNumbers) {
        Collections.shuffle(allNumbers);
        List<Integer> newNumbers = new ArrayList<>(List.copyOf(allNumbers.subList(0, TOTAL_NUMBERS_SIZE)));
        newNumbers.sort(Comparator.naturalOrder());
        return newNumbers;
    }

    public boolean containsNumber(int index, int number) {
        return numbers.get(index).contains(number);
    }

    public int getNumbersSize() {
        return this.numbers.size();
    }

    public List<List<Integer>> getNumbers() {
        return this.numbers;
    }
}
