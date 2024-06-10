package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int NUMBERS_LENGTH = 6;

    private final Set<Integer> numbers;

    public Lotto(Set<Integer> numbers) {
        validation(numbers);
        this.numbers = numbers;
    }

    private void validation(Set<Integer> numbers) {
        if (numbers == null || numbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public LottoRank match(WinningLotto winningLotto) {
        Set<Integer> temp = new HashSet<>(numbers);
        temp.retainAll(winningLotto.getNumbers());

        int unionCnt = temp.size();
        if (unionCnt == 3) return LottoRank.FIFTH;
        else if (unionCnt == 4) return LottoRank.FOURTH;
        return LottoRank.NONE;

    }
}
