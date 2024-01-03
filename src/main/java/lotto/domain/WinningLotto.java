package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {

    private Lotto winningNumber;
    private LottoNumber bonusNumber;

    public WinningLotto(Integer bonusNumber, Integer... winningNumber) {
        this(new LottoNumber(bonusNumber), new Lotto(winningNumber));
    }

    public WinningLotto(LottoNumber bonusNumber, Lotto winningNumber) {
        this.bonusNumber = bonusNumber;
        this.winningNumber = winningNumber;
    }

    public Rank calculateRank(Lotto lotto) {
        int duplicateNumber = winningNumber.countDuplicateNumber(lotto);
        boolean containsBonusNumber = lotto.contains(bonusNumber);
        return Rank.findRankByDuplicateCount(duplicateNumber, containsBonusNumber);
    }

    public Map<Rank, Integer> match(List<Lotto> allLotto) {
        Map<Rank, Integer> result = initializeLottoRankResultMap();
        for (Lotto lotto : allLotto) {
            Rank rank = calculateRank(lotto);
            result.replace(rank, result.get(rank) + 1);
        }
        return result;
    }

    private Map<Rank, Integer> initializeLottoRankResultMap() {
        Map<Rank, Integer> lottoResultMap = new HashMap<>();
        for (Rank rank : Rank.values()) {
            lottoResultMap.put(rank, 0);
        }
        return lottoResultMap;
    }
}
