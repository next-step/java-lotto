package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWinner {

    private List<Integer> winningNumbers = new ArrayList<>();

    public void selectWinningNumbers(final String winningNumbersString) {
        String[] numbers = winningNumbersString.split(",");

        for (String number : numbers) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
