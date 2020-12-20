package step2;

public class LottoMarket {

    public static Lotto purchase(LottoNumberGenerateStrategy lottoNumberGenerateStrategy) {
        return new Lotto(lottoNumberGenerateStrategy.generateLottoNumbers());
    }

}
