package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int NUMBER_OF_NUMBERS = 6;
    private static final int MAX_NUMBER = 45;

    private List<Integer> numbers = new ArrayList<>();

    public Lotto(String manualNumbers) {
        String[] splitManualNumbers = splitBySeparator(manualNumbers);
        setManualLotto(splitManualNumbers);
    }

    public String[] splitBySeparator(String manualNumbers) {
        String separator = ", ";
        return manualNumbers.split(separator);
    }

    private void setManualLotto(String[] manualNumbers) {
        for (int i = 0; i < manualNumbers.length; i++) {
            addNumber(convertToInt(manualNumbers[i]));
        }
    }

    private int convertToInt(String number) {
        return Integer.parseInt(number);
    }

    public Lotto() {
        List<Integer> rangeOfNumbers = new ArrayList<>();
        for (int j = 0; j < MAX_NUMBER; j++) {
            rangeOfNumbers.add(j + 1);
        }

        Collections.shuffle(rangeOfNumbers);
        for (int j = 0; j < NUMBER_OF_NUMBERS; j++) {
            addNumber(rangeOfNumbers.get(j));
        }
        Collections.sort(numbers);
    }

    public void addNumber(int number) {
        numbers.add(number);
    }

    public int countWinningNumbers(List<Integer> winningNumbers) {
        int count = 0;
        for (int i = 0; i < NUMBER_OF_NUMBERS; i++) {
            if (numbers.contains(winningNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
