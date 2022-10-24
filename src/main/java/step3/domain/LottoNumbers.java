package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private List<LottoNumber> lottoNumbers = new ArrayList<>();
    public static final int LOTTO_DEFAULT_SIZE = 6;

    private LottoNumbers(List<LottoNumber> generatedNumbers) {
        validateLottoNumbers(generatedNumbers);
        lottoNumbers.addAll(generatedNumbers);
        lottoNumbers.sort(LottoNumber::compareTo);
    }

    private void validateLottoNumbers(List<LottoNumber> generatedNumbers) {
        if (generatedNumbers.size() != LOTTO_DEFAULT_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }
    }

    public static LottoNumbers from(List<LottoNumber> generatedNumbers) {
        return new LottoNumbers(generatedNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
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
