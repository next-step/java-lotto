package lotto.domain.generator;

import lotto.domain.model.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StaticLottoNumberGenerator implements LottoNumberGenerator {
    private final List<LottoNumber> lottoNumbers;

    public StaticLottoNumberGenerator(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    }

    @Override
    public List<LottoNumber> generate()  {
        return new ArrayList<>(this.lottoNumbers);
    }
}
