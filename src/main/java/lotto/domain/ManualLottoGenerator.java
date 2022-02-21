package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoGenerator {

    private static final int COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public ManualLottoGenerator(List<LottoNumber> line) {
        this.lottoNumbers = line.stream().limit(COUNT).collect(Collectors.toList());
    }

    @Override
    public List<LottoNumber> getLottoGeneratorNumbers() {
        return lottoNumbers;
    }
}
