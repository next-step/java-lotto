package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class LottoNumbers {
    private Set<Integer> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = new GenerateLottoNumber().getLottoNumbers();
    }

    public LottoNumbers(Set<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Set<Integer> getLottoNumbers() {
        return new TreeSet<>(lottoNumbers);
    }

    @Override
    public String toString() {
        return "LottoNumbers{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
