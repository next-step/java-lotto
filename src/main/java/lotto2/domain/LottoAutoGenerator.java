package lotto2.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoAutoGenerator implements GenerateStrategy {
    private static int MAX_LOTTO_COUNT = 6;
    private final LottoNumbers lottoNumbers;

    public LottoAutoGenerator() {
        this.lottoNumbers = new LottoNumbers();
    }

    @Override
    public Set<LottoNumber> generateNumbers() {
        List<LottoNumber> generatedLottoNumbers = shuffle(lottoNumbers.getLottoNumbers());
        return new HashSet<>(generatedLottoNumbers.subList(0, MAX_LOTTO_COUNT));
    }

    private List<LottoNumber> shuffle(List<LottoNumber> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }
}
