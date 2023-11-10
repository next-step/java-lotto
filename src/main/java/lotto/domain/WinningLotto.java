package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final List<Integer> numbers;

    public WinningLotto(List<Integer> numbers) {
        LottoValidator.validate(numbers);
        this.numbers = numbers;
    }

    public LottoRank winningRank(Lotto lotto) {
        int count = 0;
        for(int number : numbers) {
            if(lotto.contains(number)) count++;
        }

        return LottoRank.searchBy(count);
    }
}
