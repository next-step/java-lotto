package lotto.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lotto.enums.Ranks;

public class Lotto {
    public static final int TOTAL_NUMBERS_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = new ArrayList<>(TOTAL_NUMBERS_SIZE);
        this.numbers.addAll(getRandomNumbers(AllNumbers.getNumbers()));
    }

    public Ranks getRankOfNumbers(List<Integer> winningNumbers, int bonusNumber) {
        List<Integer> numbersCopy = new ArrayList<>(List.copyOf(numbers));
        numbersCopy.retainAll(winningNumbers);
        return getRanks(numbersCopy, bonusNumber);
    }

    private Ranks getRanks(List<Integer> numbers, int bonusNumber) {
        for (Ranks rank : Arrays.stream(Ranks.values()).sorted(Comparator.reverseOrder()).collect(Collectors.toList())) {
            if (rank.isWin(numbers.size()) && rank.isCheckBonusNumber() && this.numbers.contains(bonusNumber)) {
                return rank;
            }
            if (rank.isWin(numbers.size()) && !rank.isCheckBonusNumber()) {
                return rank;
            }
        }
        return Ranks.MISS;
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

    private List<Integer> getRandomNumbers(List<Integer> allNumbers) {
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
