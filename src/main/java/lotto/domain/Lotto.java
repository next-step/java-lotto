package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Rank calculateRank(List<Integer> winningNumbers, Integer bonusNumber) {
        Rank rank = new Rank();
        for (LottoNumber lottoNumber : lottoNumbers) {
            int matchingNumberCount = lottoNumber.findMatchingNumberCount(winningNumbers);
            boolean containBonusNumber = lottoNumber.isContainBonusNumber(bonusNumber);
            rank.settingRank(matchingNumberCount, containBonusNumber);
        }

        return rank;
    }

    public int getLottoSize() {
        return lottoNumbers.size();
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(lottoNumbers);
    }
}
