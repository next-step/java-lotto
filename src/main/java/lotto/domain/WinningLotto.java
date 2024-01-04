package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {

    private Lotto winningNumber;
    private LottoNumber bonusNumber;


    public WinningLotto(Lotto winningNumber, LottoNumber bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Rank calculateRank(Lotto lotto) {
        int duplicateNumber = winningNumber.countDuplicateNumber(lotto);
        boolean containsBonusNumber = lotto.contains(bonusNumber);
        return Rank.findRankByDuplicateCount(duplicateNumber, containsBonusNumber);
    }

    public LottoResult match(List<Lotto> allLotto) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : allLotto) {
            lottoResult.add(calculateRank(lotto));
        }
        return lottoResult;
    }

}
