package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    private LottoNumbers(List<LottoNumber> generatedNumbers) {
        lottoNumbers.addAll(generatedNumbers);
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
