package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> numbers,
                        int bonusNumber) {
        this(new Lotto(numbers), new LottoNumber(bonusNumber));
    }

    public WinningLotto(Lotto numbers,
                        LottoNumber bonusNumber) {
        this.lotto = numbers;
        validateDuplicationNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicationNumber(LottoNumber bonusNumber) {
        if(lotto.contains(bonusNumber)){
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
        return LottoRank.searchBy(this.lotto.matchedCount(lotto), lotto.contains(bonusNumber));
    }
}
