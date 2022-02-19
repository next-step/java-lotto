package lotto.domain;

import static lotto.domain.RandomLottoGenerator.COUNT;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoGenerator {

    private final List<LottoNumber> lottoNumbers;

    public ManualLottoGenerator(List<Integer> line) {
        this.lottoNumbers = line.stream().limit(COUNT).sorted()
            .collect(Collectors.toList()).stream().map(LottoNumber::new).collect(
                Collectors.toList());
    }

    @Override
    public List<LottoNumber> getLottoGeneratorNumbers() {
        return lottoNumbers;
    }
}
