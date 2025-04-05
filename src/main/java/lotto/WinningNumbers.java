package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    private final List<Integer> numbers;
    private final int bonusNumber;


    public WinningNumbers(String inputNumbers, String inputBonusNumber) {
        if (inputNumbers == null || inputBonusNumber == null) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
        if (inputNumbers.isBlank() || inputBonusNumber.isBlank()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : inputNumbers.split(",")) {
            winningNumbers.add(parseNumber(number));
        }
        this.numbers = winningNumbers;
        this.bonusNumber = parseNumber(inputBonusNumber);
    }

    private int parseNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 숫자여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
