package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private List<Integer> lottoNumbers = new ArrayList<>();
    private static final int LOTTO_NUMBER_COUNT = 6;

    private LottoNumbers() {
        generateLottoNumbers();
    }

    public static LottoNumbers newInstance() {
        return new LottoNumbers();
    }

    private void generateLottoNumbers() {
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            this.lottoNumbers.add(LottoNumberGenerator.generateLottoNumber());
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
