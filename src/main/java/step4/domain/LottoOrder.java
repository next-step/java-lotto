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
    private final int manualCount;

    private LottoOrder(Amount totalPrice, Lottos lottos, int manualCount) {
        this.price = totalPrice;
        this.lottos = lottos;
        this.manualCount = manualCount;
    }

    // 전부 자동구매
    public static LottoOrder ofAuto(int totalPrice) {
        Amount totalAmount = new Amount(totalPrice);
        int totalQuantity = totalAmount.divideIntoCount(DEFAULT_LOTTO_PRICE);
        return new LottoOrder(totalAmount, Lottos.ofAutoCount(totalQuantity), 0);
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
        return new LottoOrder(totalAmount, lottos, manualInputs.size());
    }

    public int size() {
        return lottos.size();
    }

    public Amount price() {
        return price;
    }

    public int manualCount() {
        return manualCount;
    }

    public int autoCount() {
        return lottos.size() - manualCount;
    }

    public Lottos lottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return lottos.allLottoNumbersToString();
    }
}
