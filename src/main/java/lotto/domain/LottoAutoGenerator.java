package lotto.domain;

import java.util.*;

public class LottoAutoGenerator implements GenerateStrategy {
    private static int MAX_LOTTO_COUNT = 6;
    private final LottoNumbers lottoNumbers;

    public LottoAutoGenerator() {
        this.lottoNumbers = new LottoNumbers();
    }

    @Override
    public List<LottoNumber> generateNumbers() {
        List<LottoNumber> generatedLottoNumbers = shuffle(lottoNumbers.getLottoNumbers());
        return new ArrayList<>(generatedLottoNumbers.subList(0, MAX_LOTTO_COUNT));
    }

    private List<LottoNumber> shuffle(List<LottoNumber> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }
}
