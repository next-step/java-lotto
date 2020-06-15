package step2.domain.strategy;

@FunctionalInterface
public interface LottoNumberGeneratorStrategy {
    int LOTTO_NUMBER_RANGE_MAX = 44;
    int generateLottoNumber();
}
