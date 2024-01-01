package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningNumbers {

    private LottoNumbers winningNumber;
    private LottoNumber bonusNumber;

    public WinningNumbers(Integer bonusNumber, Integer... winningNumber) {
        this(new LottoNumber(bonusNumber), new LottoNumbers(winningNumber));
    }

    public WinningNumbers(LottoNumber bonusNumber, LottoNumbers winningNumber) {
        this.bonusNumber = bonusNumber;
        this.winningNumber = winningNumber;
    }

    public Rank calculateRank(LottoNumbers lottoNumbers) {
        int duplicateNumber = winningNumber.countDuplicateNumber(lottoNumbers);
        if (duplicateNumber == 5) {
            return lottoNumbers.contains(bonusNumber) ? Rank.SECOND : Rank.THIRD;
        }
        return Rank.findRankByDuplicateCount(duplicateNumber);
    }

    public Map<Rank, Integer> calculateLottoResult(List<LottoNumbers> allLottoNumbers) {
        Map<Rank, Integer> result = initializeLottoRankResultMap();
        for (LottoNumbers lottoNumbers : allLottoNumbers) {
            Rank rank = calculateRank(lottoNumbers);
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
