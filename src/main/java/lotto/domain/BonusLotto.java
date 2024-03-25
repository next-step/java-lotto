package lotto.domain;

import java.util.Set;

public class BonusLotto  {

    private final Lotto winNumber;
    private final LottoNumber bonusNumber;

    public BonusLotto(Lotto winNumber, LottoNumber bonusNumber) {
        if (winNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호와 당첨 번호가 중복됩니다.");
        }
        this.winNumber = winNumber;
        this.bonusNumber = bonusNumber;
    }

    public boolean isBonusNumberExist(final Set<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(bonusNumber));
    }
}
