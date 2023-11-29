package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    List<Integer> winningNumbers = new ArrayList<>();

    public WinningNumbers(String numbers) {
        String[] strArr = numbers.split(", ");
        for (String s : strArr) {
            winningNumbers.add(Integer.parseInt(s));
        }
    }
}
