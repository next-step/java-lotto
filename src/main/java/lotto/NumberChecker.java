package lotto;

import java.util.List;

public class NumberChecker {
    List<Integer> winnerNumber;

    public NumberChecker(List<Integer> winnerNumbers) {
        this.winnerNumber = winnerNumbers;
    }

    public int validate(List<Integer> ticket) {
        int result = 0;
        for (Integer number : ticket) {
            result += plusIfHas(number);
        }

        return result;
    }

    private int plusIfHas(int number) {
        return winnerNumber.contains(number) ? 1 : 0;
    }
}
