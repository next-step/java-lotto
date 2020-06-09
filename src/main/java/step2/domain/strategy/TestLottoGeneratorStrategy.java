package step2.domain.strategy;

public class TestLottoGeneratorStrategy implements LottoGeneratorStrategy {

    int number = 1;

    @Override
    public int getLottoNumber() {
        return number++;
    }
}
