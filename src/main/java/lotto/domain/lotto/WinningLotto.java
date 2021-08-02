package lotto.domain.lotto;

import lotto.domain.lotto.number.LottoNumber;
import lotto.domain.lotto.number.LottoNumbers;

import java.util.Objects;

public class WinningLotto {

    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    private WinningLotto(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        validate(lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        validateLottoNumbers(lottoNumbers);
        validateBonusNumber(lottoNumbers, bonusNumber);
    }

    private void validateLottoNumbers(LottoNumbers lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalStateException("로또번호들의 값은 항상 있어야합니다");
        }
    }

    private void validateBonusNumber(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        if (Objects.isNull(bonusNumber)) {
            throw new IllegalStateException("보너스 번호는 null이면 안됩니다");
        }

        checkDuplicatedBonusNumber(lottoNumbers, bonusNumber);
    }

    private void checkDuplicatedBonusNumber(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalStateException("보너스 번호는 기존 로또번호에 중복될 수 없습니다.");
        }
    }

    public static WinningLotto of(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        return new WinningLotto(lottoNumbers, bonusNumber);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.getLottoNumbers().stream()
                .anyMatch(lottoNumber::equals);
    }

    public boolean containsBonusNumber(LottoNumber lottoNumber) {
        return bonusNumber.equals(lottoNumber);
    }
}
