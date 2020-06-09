package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private static final LottoGenerator lottoGenerator = new AutoLottoGenerator();

    public LottoMachine() {
    }

    public List<Lotto> buy(Price price, List<List<Integer>> manualLottoNumbersList) {
        validatePurchasable(price, manualLottoNumbersList.size());

        int lottoCount = getLottoCount(price);

        List<Lotto> manualLottoList = manualLottoNumbersList.stream().map(Lotto::new).collect(Collectors.toList());

        List<Lotto> autoLottoList = IntStream.range(manualLottoList.size(), lottoCount).mapToObj(i -> lottoGenerator.generate()).collect(Collectors.toList());

        return Stream.concat(manualLottoList.stream(), autoLottoList.stream()).collect(Collectors.toList());
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
