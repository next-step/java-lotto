package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private List<Integer> lottoNumbers = new ArrayList<>();

    private LottoNumbers() {
        generateLottoNumbers();
    }

    public static LottoNumbers newInstance() {
        return new LottoNumbers();
    }

    private void generateLottoNumbers() {
        lottoNumbers.addAll(LottoNumberGenerator.generateLottoNumber());
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
