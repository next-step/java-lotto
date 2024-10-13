package lotto.domain;

import static lotto.domain.LottoRank.SECOND;
import static lotto.domain.LottoRank.THIRD;

import java.util.List;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public Lotto(String[] inputNumbers) {
        this.lottoNumbers = LottoNumbers.stringLottoNumbers(inputNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }

    public LottoRank getLottoResult(WinningLotto winningLotto) {
        int equalCount = lottoNumbers.getMatchCount(winningLotto.getWinningLotto());
        return getRank(equalCount, winningLotto.getBonusNumber());
    }

    private LottoRank getRank(int equalCount, int bonusNumber) {
        LottoRank lottoRank = LottoRank.matchRank(equalCount);
        if (lottoRank.equals(SECOND)) {
            return isSecondRank(bonusNumber);
        }
        return lottoRank;
    }

    private LottoRank isSecondRank(int bonusNumber) {
        if (lottoNumbers.isNumberContain(bonusNumber)) {
            return SECOND;
        }
        return THIRD;
    }

    public void validateDuplicate(int number) {
        lottoNumbers.validateDuplicate(number);
    }
}
