package step2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMarketDealer {
    private static final int LOTTO_PRICE = 1000;

    public static Lottos purchase(LottoPurchaseRequest request) {
        if (!request.valid(Money.of(LOTTO_PRICE))) {
            throw new IllegalArgumentException("Money is invalid");
        }
        List<Lotto> manualLottos = request.getManualNumbers().stream()
                .map(item -> LottoMarket.purchase(new ManualLottoNumberGenerateStrategy(item)))
                .collect(Collectors.toList());
        AutoLottoNumberGenerateStrategy autoLottoNumberGenerateStrategy = new AutoLottoNumberGenerateStrategy();
        List<Lotto> autoLottos = IntStream.range(0, request.getAutoCount(Money.of(LOTTO_PRICE)))
                .mapToObj(i -> LottoMarket.purchase(autoLottoNumberGenerateStrategy))
                .collect(Collectors.toList());
        return new Lottos(manualLottos, autoLottos);
    }
}
