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
}
