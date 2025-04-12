package lotto.model;

import lotto.utils.LottoGenerator;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLotto extends LottoGroup {
    private LottoGenerator lottoGenerator = new LottoGenerator();

    public AutoLotto(int count) {
        this.lottos = IntStream.range(0, count)
                               .mapToObj(lotto -> generate())
                               .collect(Collectors.toList());
        this.count = count;
    }

    private Lotto generate() {
        return new Lotto(lottoGenerator.generate());
    }
}
