package step2.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(List<Integer> givenWinningLottoNumbers, Integer bonusNumber) {
        this.lotto = new Lotto(givenWinningLottoNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public WinningLotto(int[] givenWinningLottoNumbers, Integer bonusNumber) {
        this.lotto = new Lotto(givenWinningLottoNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public Integer compareToMatchNumberCount(Lotto other) {
        return this.lotto.compareToMatchNumberCount(other);
    }
}
