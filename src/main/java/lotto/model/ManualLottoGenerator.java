package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoGenerator {

    private final List<Integer> lottoNumbers;

    public ManualLottoGenerator(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public List<LottoNumber> generateLotto() {
        return lottoNumbers.stream().map(LottoNumber::new).collect(
            Collectors.toList());
    }
}
