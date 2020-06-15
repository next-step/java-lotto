package step2.domain.strategy;

public class TestLottoGeneratorStrategy implements LottoNumberGeneratorStrategy {

    private int initNumber;
    public TestLottoGeneratorStrategy(int initNumber) {
        this.initNumber = initNumber;
    }

    @Override
    public int generateLottoNumber() {
        return initNumber++;
    }
}
