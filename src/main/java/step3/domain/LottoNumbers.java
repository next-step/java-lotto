package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private List<Integer> lottoNumbers = new ArrayList<>();

    private LottoNumbers(List<Integer> generatedNumbers) {
        lottoNumbers.addAll(generatedNumbers);
    }

    public static LottoNumbers from(List<Integer> generatedNumbers) {
        return new LottoNumbers(generatedNumbers);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
