package lotto.model;

public class RandomGenerateRule implements GenerateRule{
    @Override
    public LottoNumber generate() {
        //generate int by logics
        return new LottoNumber(1);
    }
}
