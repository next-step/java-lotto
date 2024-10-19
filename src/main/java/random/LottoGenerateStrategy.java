package random;

public class LottoGenerateStrategy implements LottoGenerator {
    private LottoGenerator lottoGeneratorStrategy;

    public LottoGenerateStrategy(LottoGenerator lottoGeneratorStrategy) {
        this.lottoGeneratorStrategy = lottoGeneratorStrategy;
    }

    @Override
    public int executeStrategy() {
        return lottoGeneratorStrategy.executeStrategy();
    }

}
