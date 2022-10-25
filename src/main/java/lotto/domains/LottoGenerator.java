package lotto.domains;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.exceptions.NotEnoughPurchasedAmountException;

public class LottoGenerator {
    public List<Lotto> purchaseByAuto(LottoPurchasedAmount amount) {
        return IntStream.range(0, amount.getAmount() / Lotto.PRICE)
                .boxed()
                .map(i -> Lotto.createByAuto())
                .collect(Collectors.toList());
    }

    public List<Lotto> purchaseByManual(LottoPurchasedAmount amount, List<String> purchasedByManualList) {
        int amountForManual = purchasedByManualList.size() * Lotto.PRICE;

        if (amount.getAmount() < amountForManual) {
            throw new NotEnoughPurchasedAmountException(amount.getAmount(), amountForManual);
        }

        return purchasedByManualList.stream()
                .map(Lotto::createByString)
                .collect(Collectors.toList());
    }
}
