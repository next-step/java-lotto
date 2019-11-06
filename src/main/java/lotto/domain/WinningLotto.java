package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class WinningLotto {

    public static final String DUPLICATED_BONUS_NUMBER_ERROR = "보너스 번호는 중복될 수 없습니다.";

    private Lotto lotto;
    private BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        assertUniqueBonusNumber(lotto.getLottoNumbers(), bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank compareNumbersTo(Lotto lotto) {
        LottoNumbers lottoNumbers = lotto.getLottoNumbers();
        return LottoRank.find(getMatchNumberCount(lottoNumbers), bonusNumber.hasMatchedNumber(lottoNumbers));
    }

    private long getMatchNumberCount(LottoNumbers lottoNumbers) {
        return lottoNumbers.getValue()
                .stream()
                .filter(lotto.getLottoNumbers().getValue()::contains)
                .count();
    }

    private void assertUniqueBonusNumber(LottoNumbers lottoNumbers, BonusNumber bonusNumber) {
        Set<Integer> uniqueNumberSet = new HashSet<>(lottoNumbers.getValue());

        if (uniqueNumberSet.contains(bonusNumber.getValue())) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER_ERROR);
        }
    }
}
