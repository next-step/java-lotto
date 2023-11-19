package step2.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> givenWinningLottoNumbers, Integer bonusNumber) {
        this.lotto = new Lotto(givenWinningLottoNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public WinningLotto(int[] givenWinningLottoNumbers, Integer bonusNumber) {
        this(Arrays.stream(givenWinningLottoNumbers)
                .boxed()
                .collect(Collectors.toList()), bonusNumber);
    }

    public Integer compareToMatchNumberCount(Lotto other) {
        return this.lotto.compareToMatchNumberCount(other);
    }

    public Boolean checkBonusNumber(Lotto other) {
        return other.containsLottoNumber(this.bonusNumber);
    }
}
