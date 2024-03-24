package lotto.fixture;

import lotto.domain.LottoNumbers;
import lotto.domain.PickedLottoNumbers;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.List;

public enum LottoNumbersFixture {
    사등_시나리오(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 11, 12, 13), Rank.FOUR),
    삼등_시나리오(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 12, 13), Rank.THIRD),
    이등_시나리오(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 13), Rank.SECOND),
    일등_시나리오(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 5, 6), Rank.FIRST);
    
    private final LottoNumbers winningNumbers;
    private final PickedLottoNumbers pickedNumbers;
    private final Rank rank;

    LottoNumbersFixture(List<Integer> winningNumbers, List<Integer> pickedNumbers, Rank rank) {
        this.winningNumbers = new LottoNumbers(winningNumbers);
        this.pickedNumbers = new PickedLottoNumbers();
        this.pickedNumbers.add(new LottoNumbers(pickedNumbers));
        this.rank = rank;
    }

    public LottoNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public PickedLottoNumbers getPickedNumbers() {
        return pickedNumbers;
    }

    public Rank getRank() {
        return rank;
    }
}
