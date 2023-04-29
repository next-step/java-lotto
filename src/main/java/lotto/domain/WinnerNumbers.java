package lotto.domain;

import lotto.domain.enums.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerNumbers {
    private final LottoNumbers winnerNumbers;
    private final LottoNumber bonusNumber;

    public WinnerNumbers(List<Integer> lottoNumbers, LottoNumber bonusNumber) {
        this.winnerNumbers = new LottoNumbers(lottoNumbers);
        this.bonusNumber = bonusNumber;

        validateBonumNumber(bonusNumber);
    }

    public WinnerNumbers(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        this.winnerNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;

        validateBonumNumber(bonusNumber);
    }

    private void validateBonumNumber(LottoNumber bonusNumber) {
        if (winnerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호에 포함될 수 없습니다.");
        }
    }

    public Rank match(LottoNumbers lottoNumbers) {
        int count = winnerNumbers.getLottoNumbers()
                .stream()
                .filter(lottoNumbers::contains)
                .collect(Collectors.toList()).size();
        boolean bonus = isMatchBonus(lottoNumbers);
        return Rank.valueOf(count, bonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinnerNumbers)) return false;

        WinnerNumbers that = (WinnerNumbers) o;

        if (!winnerNumbers.equals(that.winnerNumbers)) return false;
        return bonusNumber.equals(that.bonusNumber);
    }

    @Override
    public int hashCode() {
        int result = winnerNumbers.hashCode();
        result = 31 * result + bonusNumber.hashCode();
        return result;
    }

    public boolean isMatchBonus(LottoNumbers lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }
}
