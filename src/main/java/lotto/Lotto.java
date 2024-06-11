package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int NUMBERS_LENGTH = 6;

    private final Set<LottoNumber> numbers;

    public Lotto(Set<LottoNumber> numbers) {
        validation(numbers);
        this.numbers = numbers;
    }

    private void validation(Set<LottoNumber> numbers) {
        if (numbers == null || numbers.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }

    public LottoRank match(WinningLotto winningLotto) {
        int unionCnt = getUnionCnt(winningLotto);

        if (unionCnt == 3) return LottoRank.FIFTH;
        if (unionCnt == 4) return LottoRank.FOURTH;
        if (unionCnt == 5) return matchFiveNumbers(winningLotto);
        if (unionCnt == 6) return LottoRank.FIRST;

        return LottoRank.NONE;
    }

    private int getUnionCnt(WinningLotto winningLotto) {
        Set<LottoNumber> temp = new HashSet<>(numbers);

        temp.retainAll(winningLotto.getNumbers());

        return temp.size();
    }

    private LottoRank matchFiveNumbers(WinningLotto winningLotto) {
        return numbers.contains(winningLotto.getBonus()) ? LottoRank.SECOND : LottoRank.THIRD;
    }


}
