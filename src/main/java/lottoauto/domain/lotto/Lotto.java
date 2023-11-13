package lottoauto.domain.lotto;

import java.util.List;

public class Lotto {

    private final Numbers numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new Numbers(numbers);
    }

    public int getLottoScore(List<Integer> winnerNumbers) {
        int result = 0;

        for (Integer winnerNumber : winnerNumbers) {
            result = numbers.checkMatchCount(result, winnerNumber);
        }

        return result;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
