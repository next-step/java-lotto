package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final int NUMBER_OF_NUMBERS = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private List<Integer> numbers = new ArrayList<>();

    public Lotto(String manualNumbers) {
        String[] splitManualNumbers = splitBySeparator(manualNumbers);
        setManualLotto(splitManualNumbers);
    }

    private String[] splitBySeparator(String manualNumbers) {
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
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int j = MIN_LOTTO_NUMBER; j <= MAX_LOTTO_NUMBER; j++) {
            lottoNumbers.add(j);
        }

        Collections.shuffle(lottoNumbers);
        for (int j = 0; j < NUMBER_OF_NUMBERS; j++) {
            addNumber(lottoNumbers.get(j));
        }
        Collections.sort(numbers);
    }

    private void addNumber(int number) {
        numbers.add(number);
    }

    public int countWinningNumbers(Lotto winningNumbers) {
        int count = 0;
        for (int i = 0; i < NUMBER_OF_NUMBERS; i++) {
            if (numbers.contains(winningNumbers.getNumbers().get(i))) {
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
