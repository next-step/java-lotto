package lotto.domain.lotto;

import lotto.domain.lotto.number.LottoNumberGenerator;
import lotto.domain.lotto.number.LottoNumbers;
import lotto.domain.money.Money;
import lotto.domain.money.PaymentInfo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoOffice {
    public static final int LOWEST_AMOUNT = 1_000;
    public static final Money LOTTO_PRICE_OF_SINGLE = Money.of(LOWEST_AMOUNT);
    public static final int NOT_POSSIBLE_PURCHASE_COUNT = 0;

    private LottoOffice() {
    }

    public static Lottos purchase(PaymentInfo paymentInfo, Lottos manualLottos) {
        int availablePurchaseCount = getAvailablePurchaseCount(paymentInfo);
        if (isAffordablePurchase(availablePurchaseCount)) {
            return manualLottos;
        }

        return purchaseLotto(manualLottos, availablePurchaseCount);
    }

    private static Lottos purchaseLotto(Lottos manualLottos, int availablePurchaseCount) {
        List<Lotto> lottos = Stream.generate(LottoNumberGenerator::generate)
                .map(LottoNumbers::of)
                .map(Lotto::of)
                .limit(availablePurchaseCount)
                .collect(Collectors.toList());

        return Lottos.of(lottos).combine(manualLottos);
    }

    private static boolean isAffordablePurchase(int availablePurchaseCount) {
        return availablePurchaseCount == NOT_POSSIBLE_PURCHASE_COUNT;
    }

    private static int getAvailablePurchaseCount(PaymentInfo paymentInfo) {
        return paymentInfo.getAffordableCount(LOTTO_PRICE_OF_SINGLE);
    }

}
