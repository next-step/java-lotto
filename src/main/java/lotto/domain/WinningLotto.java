package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinningLotto {

    private final List<LottoNumber> lottoNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> lottoNumbers, LottoNumber bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
        validateBonusBall();
    }

    private void validateBonusBall() {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호와 중복 될 수 없습니다");
        }
    }

    public int numOfSize() {
        return lottoNumbers.size();
    }

    public List<LottoNumber> of() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
