package lottoauto.domain.lotto;

import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int checkMatchCount(int result, int winnerNumber) {
        if (numbers.contains(winnerNumber)) {
            return ++result;
        }
        return result;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
