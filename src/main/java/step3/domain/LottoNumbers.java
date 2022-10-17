package step3.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LottoNumbers {

    private Set<Integer> lottoNumbers = new TreeSet<>();

    private LottoNumbers(List<Integer> generatedNumbers) {
        lottoNumbers.addAll(generatedNumbers);
    }

    public static LottoNumbers from(List<Integer> generatedNumbers) {
        return new LottoNumbers(generatedNumbers);
    }

    public Set<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int calculateMatchCount(List<Integer> winningNumbers) {
        int matchCount = 0;
        for (Integer lottoNumber : lottoNumbers) {
            matchCount += winningNumbers.stream()
                .filter(winningNumber -> winningNumber == lottoNumber)
                .count();
        }
        return matchCount;
    }

    public boolean isBonusBallMatch(int bonusBall) {
        return this.lottoNumbers.contains(bonusBall);
    }
}
