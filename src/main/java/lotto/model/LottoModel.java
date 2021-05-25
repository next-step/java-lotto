package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoModel {
    private static final int numberOfNumbers = 6;
    private static final int maxNumber = 45;

    private List<Integer> numbers = new ArrayList<>();

    public LottoModel(String manualNumbers) {
        String[] splitManualNumbers = splitBySeparator(manualNumbers);
        setManualLotto(splitManualNumbers);
    }

    public String[] splitBySeparator(String manualNumbers) {
        String separator = ", ";
        return manualNumbers.split(separator);
    }

    private int convertToInt(String number) {
        return Integer.parseInt(number);
    }

    private void setManualLotto(String[] manualNumbers) {
        for (int i = 0; i < manualNumbers.length; i++) {
            addNumber(convertToInt(manualNumbers[i]));
        }
    }

    public LottoModel() {
        List<Integer> rangeOfNumbers = new ArrayList<>();
        for (int j = 0; j < maxNumber; j++) {
            rangeOfNumbers.add(j + 1);
        }

        Collections.shuffle(rangeOfNumbers);
        for (int j = 0; j < numberOfNumbers; j++) {
            addNumber(rangeOfNumbers.get(j));
        }
        Collections.sort(numbers);
    }


    public void addNumber(int number) {
        numbers.add(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public int countWinningNumbers(List<Integer> winningNumbers) {
        int count = 0;
        for (int i = 0; i < numberOfNumbers; i++) {
            if (numbers.contains(winningNumbers.get(i))) {
                count++;
            }
        }
        return count;
    }
}
