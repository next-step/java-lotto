package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWinNumbers {
    private List<Integer> winNumbers = new ArrayList<>();

    public LottoWinNumbers(String numbers) {
        initWinNumbers(numbers.split(", "));
    }

    private void initWinNumbers(String[] winNums) {
        if (winNums.length != 6) {
            throw new IllegalArgumentException();
        }

        for (String num : winNums) {
            addWinNumber(Integer.parseInt(num));
        }
    }

    private void addWinNumber(int num) {
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException();
        }
        winNumbers.add(num);
    }
}
