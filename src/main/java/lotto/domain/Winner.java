package lotto.domain;

import java.util.HashSet;
import java.util.Set;
import lotto.domain.result.LottoGameResult;

public class Winner extends Lotto {
    Winner(int num1, int num2, int num3, int num4, int num5, int num6) {
        super(num1, num2, num3, num4, num5, num6);
    }

    public Winner(Set<Integer> winningNumbers) {
        super(winningNumbers);
    }

    public static Winner of(String numberString) {
        String[] numberArray = numberString.split(", ");

        Set<Integer> winningNumbers = new HashSet<>();
        for (String number : numberArray) {
            winningNumbers.add(Integer.parseInt(number));
        }

        return new Winner(winningNumbers);
    }

    public LottoGameResult findWinners(Lottos lottos) {
        return lottos.matchNumbers(numbers);
    }
}
