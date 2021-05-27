package lotto.model;

public class MockGenerateRule implements GenerateRule{
    @Override
    public LottoNumber generate() {
        return new LottoNumber(1);
    }

    @Override
    public void init() {
        return;
    }
}
