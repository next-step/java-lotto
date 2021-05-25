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

    private void setManualLotto(String[] manualNumbers) {
        for (int i = 0; i < manualNumbers.length; i++) {
            addNumber(convertToInt(manualNumbers[i]));
        }
    }

    private int convertToInt(String number) {
        return Integer.parseInt(number);
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

    public String result(List<Integer> winningNumbers, int bonusNumber) {
        int numberOfWinningNumbers = countWinningNumbers(winningNumbers);
        boolean bonus = contains(bonusNumber);

        if (numberOfWinningNumbers == 3) {
            return "5등";
        }

        if (numberOfWinningNumbers == 4) {
            return "4등";
        }

        if (numberOfWinningNumbers == 5 && !bonus) {
            return "3등";
        }

        if (numberOfWinningNumbers == 5 && bonus) {
            return "2등";
        }

        if (numberOfWinningNumbers == 6) {
            return "1등";
        }
        return "당첨되지 않았습니다.";
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

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
