package lotto.fixture;

import lotto.domain.LottoNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.List;

public enum LottoNumbersFixture {
    오등_시나리오(Arrays.asList(1, 2, 3, 4, 5, 6), new LottoNumber(7),Arrays.asList(1, 2, 3, 11, 12, 13), Rank.FIVE),
    사등_시나리오(Arrays.asList(1, 2, 3, 4, 5, 6), new LottoNumber(7), Arrays.asList(1, 2, 3, 4, 12, 13), Rank.FOUR),
    삼등_시나리오(Arrays.asList(1, 2, 3, 4, 5, 6), new LottoNumber(7), Arrays.asList(1, 2, 3, 4, 5, 13), Rank.THIRD),
    이등_시나리오(Arrays.asList(1, 2, 3, 4, 5, 6), new LottoNumber(7), Arrays.asList(1, 2, 3, 4, 5, 7), Rank.SECOND),
    일등_시나리오(Arrays.asList(1, 2, 3, 4, 5, 6), new LottoNumber(7), Arrays.asList(1, 2, 3, 4, 5, 6), Rank.FIRST);
    
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;
    private final Lottos pickedNumbers;
    private final Rank rank;

    LottoNumbersFixture(List<Integer> pickedNumbers, LottoNumber bonusNumber, List<Integer> winningNumbers, Rank rank) {
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
        Lotto lotto = new Lotto(pickedNumbers);
        this.pickedNumbers = new Lottos(List.of(lotto));
        this.rank = rank;
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public Lottos getPickedNumbers() {
        return pickedNumbers;
    }

    public Rank getRank() {
        return rank;
    }
}
