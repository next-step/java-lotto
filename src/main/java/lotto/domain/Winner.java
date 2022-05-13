package lotto.domain;

import java.util.HashSet;
import java.util.Set;
import lotto.domain.result.LottoGameResult;

public class Winner extends Lotto {
    private int bonusNumber;

    Winner(int num1, int num2, int num3, int num4, int num5, int num6, int bonusNumber) {
        super(num1, num2, num3, num4, num5, num6);
        this.bonusNumber = bonusNumber;
    }

    public Winner(Set<Integer> winningNumbers, int bonusNumber) {
        super(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public static Winner of(String numberString, int bonusNumber) {
        String[] numberArray = numberString.split(", ");

        Set<Integer> winningNumbers = new HashSet<>();
        for (int i = 0; i < LOTTO_LENGTH; ++i) {
            winningNumbers.add(Integer.parseInt(numberArray[i]));
        }

        return new Winner(winningNumbers, bonusNumber);
    }

    public LottoGameResult findWinners(Lottos lottos) {
        return lottos.matchNumbers(numbers, bonusNumber);
    }
}
