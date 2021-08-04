package lotto.model;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Lottos {
    private static final int ONE_LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    public Lottos(int purchaseAmount) {
        validatePurchasableAmount(purchaseAmount);

        int lottoCount = purchaseAmount / ONE_LOTTO_PRICE;
        this.lottos = Stream.generate(Lotto::new)
                .limit(lottoCount)
                .collect(toList());
    }

    private void validatePurchasableAmount(int purchaseAmount) {
        if (purchaseAmount < ONE_LOTTO_PRICE) {
            throw new IllegalArgumentException(String.format("구입금액은 최소 %d(원) 이상이어야 합니다.", ONE_LOTTO_PRICE));
        }
    }

    public int getSize() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
