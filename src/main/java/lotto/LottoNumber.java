package lotto;

import java.util.List;

public class LottoNumber {

    private final List<Integer> numbers;

    public LottoNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getContainsNumberCount(List<Integer> winnerNumbers) {
        int count = 0;

        for (Integer winnerNumber : winnerNumbers) {
            if (numbers.contains(winnerNumber)) {
                count++;
            }
        }

        return count;
    }
}
