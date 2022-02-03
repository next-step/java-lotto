package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMatcher {

    public static int compare(String[] numbers, List<Integer> lotto) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : numbers) {
            winningNumbers.add(Integer.parseInt(number));
        }

        int count = 0;
        for (Integer number : lotto) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
}
