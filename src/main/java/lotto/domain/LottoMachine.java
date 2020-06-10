package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private static final LottoGenerator lottoGenerator = new AutoLottoGenerator();

    public LottoMachine() {
    }

    public Lottos buy(Price price, List<List<Integer>> manualLottoNumbersList) {
        validatePurchasable(price, manualLottoNumbersList.size());

        int lottoCount = getLottoCount(price);

        Lottos manualLottos = Lottos.of(manualLottoNumbersList.stream().map(Lotto::new).collect(Collectors.toList()));

        Lottos autoLottos = Lottos.of(IntStream.range(manualLottos.size(), lottoCount).mapToObj(i -> lottoGenerator.generate()).collect(Collectors.toList()));

        return Lottos.of(manualLottos, autoLottos);
    }

    private int getLottoCount(Price price) {
        return price.getPrice() / LOTTO_PRICE;
    }

    private void validatePurchasable(Price price, int manualLottoCount) {
        if (price.getPrice() < manualLottoCount * LOTTO_PRICE) {
            throw new IllegalArgumentException("price of manualLotto is over `price`");
        }
        if (price.getPrice() < LOTTO_PRICE) {
            throw new IllegalArgumentException(String.format("`price` is grater than %d", LOTTO_PRICE));
        }
        if (price.getPrice() / LOTTO_PRICE * LOTTO_PRICE != price.getPrice()) {
            throw new IllegalArgumentException(String.format("`price` is must be multiple of %d", LOTTO_PRICE));
        }
    }
}
