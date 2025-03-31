package Lotto.domain;

import java.util.*;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int countMatches(Set<LottoNumber> winningNumbers) {
        Set<LottoNumber> intersection = new HashSet<>(this.lottoNumbers);
        intersection.retainAll(winningNumbers);
        return intersection.size();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
