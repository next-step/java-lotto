package lotto;

import java.util.HashSet;
import java.util.Set;

public class LottoNumbers {
    private Set<Integer> lottoNumbers;

    public LottoNumbers() {
        lottoNumbers = new GenerateLottoNumber().getLottoNumbers();
    }

    public Set<Integer> getLottoNumbers() {
        return new HashSet<>(lottoNumbers);
    }
}
