package step2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMarket {
    private static final int LOTTO_PRICE = 1000;

    public static Lottos purchase(Money money, LottoNumberGenerateStrategy generateStrategy) {
        int purchasableCount = money.divide(LOTTO_PRICE);
        List<LottoNumbers> lottoNumbers = IntStream.range(0, purchasableCount)
                .mapToObj(i -> generateStrategy.generateLottoNumbers())
                .collect(Collectors.toList());
        return new Lottos(lottoNumbers);
    }

}
