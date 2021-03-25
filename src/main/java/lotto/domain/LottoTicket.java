package lotto.domain;

import java.util.Objects;

public class LottoTicket {
    private static final String BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE = "보너스 번호는 다른 로또 번호와 중복될 수 없습니다.";

    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    public LottoTicket(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        validateDuplicateBonusNumber(lottoNumbers, bonusNumber);

        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateBonusNumber(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public LottoNumbers lottoNumbers() {
        return lottoNumbers;
    }

    public int matchingLottoNumbersCount(LottoTicket that) {
        return lottoNumbers.matchingCount(that.lottoNumbers);
    }

    public boolean sameBonusNumber(LottoTicket that) {
        return bonusNumber == that.bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket that = (LottoTicket) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers, bonusNumber);
    }
}
