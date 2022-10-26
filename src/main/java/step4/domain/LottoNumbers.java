package step4.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LottoNumbers {

    private Set<LottoNumber> lottoNumbers = new TreeSet<>();
    public static final int LOTTO_DEFAULT_SIZE = 6;

    private LottoNumbers(Set<LottoNumber> generatedNumbers) {
        validateLottoNumbers(generatedNumbers);
        this.lottoNumbers = generatedNumbers;
    }

    private void validateLottoNumbers(Set<LottoNumber> generatedNumbers) {
        if (generatedNumbers.size() != LOTTO_DEFAULT_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    public static LottoNumbers from(Set<LottoNumber> generatedNumbers) {
        return new LottoNumbers(generatedNumbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int calculateMatchCount(List<Integer> winningNumbers) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            matchCount += winningNumbers.stream()
                .filter(winningNumber -> lottoNumber.equals(LottoNumber.from(winningNumber)))
                .count();
        }
        return matchCount;
    }

    public boolean hasNumber(int bonusBall) {
        return this.lottoNumbers.contains(LottoNumber.from(bonusBall));
    }
}
