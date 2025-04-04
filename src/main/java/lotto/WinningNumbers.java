package lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    private final List<Integer> inputNumbers;

    public WinningNumbers(String inputNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : inputNumbers.split(",")) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        this.inputNumbers = winningNumbers;
    }

    public List<Integer> getInputNumbers() {
        return inputNumbers;
    }
}
