package lotto.numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lotto.enums.Ranks;

public class Lotto {
    public static final int TOTAL_NUMBERS_SIZE = 6;
    public static final int PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = new ArrayList<>(TOTAL_NUMBERS_SIZE);
        this.numbers.addAll(getRandomNumbers(AllNumbers.getNumbers()));
    }

    public Ranks getRankOfNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers, bonusNumber);
        validateBonusNumbers(bonusNumber);

        List<Integer> pickedNumbers = new ArrayList<>(List.copyOf(numbers));
        pickedNumbers.retainAll(winningNumbers);
        return getRanks(pickedNumbers, bonusNumber);
    }

    private void validateWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        if(winningNumbers.isEmpty() || winningNumbers.size() != Lotto.TOTAL_NUMBERS_SIZE) {
            throw new IllegalArgumentException("당첨번호는 6자리여야 합니다.");
        }

        List<Integer> filteringNumbers = winningNumbers.stream()
                                                       .filter(number -> number > 0 && number <= AllNumbers.LAST_NUMBER)
                                                       .collect(Collectors.toList());

        if(filteringNumbers.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("각 당첨번호의 범위는 1에서 45사이의 숫자입니다.");
        }

        if(winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호 이외의 숫자여야 합니다.");
        }
    }

    private void validateBonusNumbers(int bonusNumber) {
        if(bonusNumber <= 0 || bonusNumber > AllNumbers.LAST_NUMBER) {
            throw new IllegalArgumentException("보너스 번호의 범위는 1에서 45사이의 숫자입니다.");
        }
    }

    private Ranks getRanks(List<Integer> pickedNumbers, int bonusNumber) {
        if(this.numbers.contains(bonusNumber)) {
            return Ranks.getRank(pickedNumbers.size(), true);
        }
        return Ranks.getRank(pickedNumbers.size(), false);
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
