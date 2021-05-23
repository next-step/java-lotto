package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoShop {
    private static final int MINIMUM_QUANTITY = 1;

    public Lottos buyLottos(long price, List<LottoNumbers> manuals) {
        int autoLottosCount = getLottoCountByPrice(price) - manuals.size();
        List<Lotto> lottos = buyManualLottos(manuals);
        lottos.addAll(buyAutoLottos(autoLottosCount));
        return new Lottos(lottos);
    }

    private int getLottoCountByPrice(long price) {
        return Money.from(price).divide(Money.from(Lotto.PRICE)).intValue();
    }

    private List<Lotto> buyManualLottos(List<LottoNumbers> manuals) {
        return manuals.stream()
                .map(Lotto::manual)
                .collect(Collectors.toList());
    }

    private List<Lotto> buyAutoLottos(int autoLottosCount) {
        return IntStream.rangeClosed(MINIMUM_QUANTITY, autoLottosCount)
                .mapToObj(count -> Lotto.auto())
                .collect(Collectors.toList());
    }
}
