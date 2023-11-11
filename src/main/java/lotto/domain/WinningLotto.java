package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final LottoNumbers lottoNumbers;
    private final Bonus bonus;

    public WinningLotto(List<Integer> numbers,
                        int bonusNumber) {
        this.lottoNumbers = new LottoNumbers(numbers);
        this.bonus = new Bonus(bonusNumber);
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
        int count = lottoNumbers.matchedCount(lotto);

        return LottoRank.searchBy(count, false);
    }
}
