package random;

import java.util.List;

public class LottoGenerateStrategy implements LottoGenerator {
    private LottoGenerator lottoGeneratorStrategy;

    public LottoGenerateStrategy(LottoGenerator lottoGeneratorStrategy) {
        this.lottoGeneratorStrategy = lottoGeneratorStrategy;
    }

    @Override
    public List<Integer> executeStrategy() {
        return lottoGeneratorStrategy.executeStrategy();
    }

}
