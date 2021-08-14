package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningNumber {

    private final List<Integer> winningNumbers = new ArrayList<>();

    public void selectWinningNumbers(final String winningNumbersString) {
        String[] numbers = winningNumbersString.split(",");

        for (String number : numbers) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumbers;
    }

}
