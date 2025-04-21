package step4.domain;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 로또 구매 요청
 */
public class LottoOrder {
    private static final Amount DEFAULT_LOTTO_PRICE = new Amount(1_000);
    private final Amount price;
    private final Lottos lottos;

    private LottoOrder(Amount totalPrice, Lottos lottos) {
        this.price = totalPrice;
        this.lottos = lottos;
    }

    // 전부 자동구매
    public static LottoOrder ofAuto(int totalPrice) {
        Amount totalAmount = new Amount(totalPrice);
        int totalQuantity = totalAmount.divideIntoCount(DEFAULT_LOTTO_PRICE);
        return new LottoOrder(totalAmount, Lottos.ofAutoCount(totalQuantity));
    }

    // 반자동(수동+자동) 구매요청
    public static LottoOrder ofCombined(int totalPrice, List<String> manualInputs) {
        Amount totalAmount = new Amount(totalPrice);
        int totalQuantity = totalAmount.divideIntoCount(DEFAULT_LOTTO_PRICE);
        List<Lotto> manualLottos = manualInputs.stream()
            .map(LottoNumbers::ofManual)
            .map(Lotto::ofManual)
            .collect(Collectors.toList());

        int restCount = totalQuantity - manualLottos.size();
        Lottos lottos = Lottos.ofMixed(manualLottos, restCount);
        return new LottoOrder(totalAmount, lottos);
    }

    public Lottos lottos() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public Amount price() {
        return price;
    }
}
