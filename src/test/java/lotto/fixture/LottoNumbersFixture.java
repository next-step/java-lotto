package lotto.fixture;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.PickedLottoNumbers;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.List;

public enum LottoNumbersFixture {
    오등_시나리오(Arrays.asList(1, 2, 3, 4, 5, 6), new LottoNumber(7),Arrays.asList(1, 2, 3, 11, 12, 13), Rank.FIVE),
    사등_시나리오(Arrays.asList(1, 2, 3, 4, 5, 6), new LottoNumber(7), Arrays.asList(1, 2, 3, 4, 12, 13), Rank.FOUR),
    삼등_시나리오(Arrays.asList(1, 2, 3, 4, 5, 6), new LottoNumber(7), Arrays.asList(1, 2, 3, 4, 5, 13), Rank.THIRD),
    이등_시나리오(Arrays.asList(1, 2, 3, 4, 5, 6), new LottoNumber(7), Arrays.asList(1, 2, 3, 4, 5, 7), Rank.SECOND),
    일등_시나리오(Arrays.asList(1, 2, 3, 4, 5, 6), new LottoNumber(7), Arrays.asList(1, 2, 3, 4, 5, 6), Rank.FIRST);
    
    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;
    private final PickedLottoNumbers pickedNumbers;
    private final Rank rank;

    LottoNumbersFixture(List<Integer> winningNumbers, LottoNumber bonusNumber, List<Integer> pickedNumbers, Rank rank) {
        this.winningNumbers = new LottoNumbers(winningNumbers);
        this.bonusNumber = bonusNumber;
        LottoNumbers lottoNumbers = new LottoNumbers(pickedNumbers);
        this.pickedNumbers = new PickedLottoNumbers(List.of(lottoNumbers));
        this.rank = rank;
    }

    public LottoNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public PickedLottoNumbers getPickedNumbers() {
        return pickedNumbers;
    }

    public Rank getRank() {
        return rank;
    }
}
