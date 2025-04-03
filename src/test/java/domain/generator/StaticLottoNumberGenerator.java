package domain.generator;

import java.util.ArrayList;
import java.util.List;

public class StaticLottoNumberGenerator implements LottoNumberGenerator {
    private final List<Integer> lottoNumbers;

    public StaticLottoNumberGenerator(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public List<Integer> generate()  {
        return new ArrayList<>(this.lottoNumbers);
    }
}
