package step4.domain;

import java.util.Set;

public class LottoNumbers {

    private Set<LottoNumber> lottoNumbers;
    public static final int LOTTO_DEFAULT_SIZE = 6;

    private LottoNumbers(Set<LottoNumber> lottoNumbers) {
        validateLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoNumbers(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_DEFAULT_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    public static LottoNumbers from(Set<LottoNumber> lottoNumbers) {
        return new LottoNumbers(lottoNumbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int calculateMatchCount(Set<LottoNumber> winningNumbers) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            matchCount += winningNumbers.stream()
                .filter(winningNumber -> lottoNumber.equals(winningNumber))
                .count();
        }
        return matchCount;
    }

    public boolean hasNumber(int bonusNumber) {
        return this.lottoNumbers.contains(LottoNumber.from(bonusNumber));
    }
}
