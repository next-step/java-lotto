package lotto.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    public static final int TOTAL_NUMBERS_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = new ArrayList<>(TOTAL_NUMBERS_SIZE);
        this.numbers.addAll(getNumbers(AllNumbers.getNumbers()));
    }

    public int countSameNumbers(List<Integer> winningNumbers) {
       List<Integer> numbersCopy = new ArrayList<>(List.copyOf(numbers));
       numbersCopy.retainAll(winningNumbers);
       return numbersCopy.size();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int j = 0; j < numbers.size(); j++) {
            result.append(numbers.get(j));
            addComma(j, numbers.size() - 1, result);
        }
        result.append("]");
        return result.toString();
    }

    private List<Integer> getNumbers(List<Integer> allNumbers) {
        Collections.shuffle(allNumbers);
        List<Integer> newNumbers = new ArrayList<>(List.copyOf(allNumbers.subList(0, TOTAL_NUMBERS_SIZE)));
        newNumbers.sort(Comparator.naturalOrder());
        return newNumbers;
    }

    private void addComma(int index, int endIndex, StringBuilder result) {
        if (index < endIndex) {
            result.append(", ");
        }
    }
}
