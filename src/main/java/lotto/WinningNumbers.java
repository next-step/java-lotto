package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    private final List<Integer> numbers;

    public WinningNumbers(String inputNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : inputNumbers.split(",")) {
            winningNumbers.add(parseNumber(number));
        }
        this.numbers = winningNumbers;
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
}
