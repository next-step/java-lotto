package lottogame.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static lottogame.domain.LottoGameConstants.LOTTO_NUMBER_COUNT;

public class LottoNumbers {
    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(List<LottoNumber> numbers) {
        Set<LottoNumber> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 로또 번호가 존재합니다.");
        }

        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 정확히 " + LOTTO_NUMBER_COUNT + "개여야 합니다.");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int countMatchingNumbers(LottoNumbers other) {
        return (int) this.lottoNumbers.stream()
                .filter(other.lottoNumbers::contains)
                .count();
    }

    public boolean isMatchingBonus(LottoNumber bonusNumber) {
        return this.lottoNumbers.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumbers);
    }
}

