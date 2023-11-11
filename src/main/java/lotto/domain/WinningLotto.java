package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final Lotto lotto;
    private final Bonus bonus;

    public WinningLotto(List<Integer> numbers,
                        int bonusNumber) {
        this(new Lotto(numbers), new Bonus(bonusNumber));
    }

    public WinningLotto(Lotto numbers,
                        Bonus bonusNumber) {
        validateDuplicationNumber(bonusNumber);
        this.lotto = numbers;
        this.bonus = bonusNumber;
    }

    private void validateDuplicationNumber(Bonus bonusNumber) {
        if(bonusNumber.compareWith(lotto)){
            throw new IllegalArgumentException();
        }
    }

    public List<LottoRank> winningRank(List<Lotto> lottos) {
        List<LottoRank> list = new ArrayList<>();
        for (Lotto lotto : lottos) {
            LottoRank lottoRank = winningRank(lotto);
            list.add(lottoRank);
        }
        return list;
    }

    private LottoRank winningRank(Lotto lotto) {
        return LottoRank.searchBy(this.lotto.matchedCount(lotto), bonus.compareWith(lotto));
    }
}
