package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {

    private static final int LOTTO_SALE_PRICE = 1000;

    private final int purchaseCount;

    public LottoGame(int purchaseAmount) {
        validateLottoGame(purchaseAmount);

        this.purchaseCount = purchaseAmount / LOTTO_SALE_PRICE;
    }

    private void validateLottoGame(int purchaseAmount) {
        if (purchaseAmount < LOTTO_SALE_PRICE) {
            throw new IllegalArgumentException("구입금액이 1000원 이상 이어야 합니다.");
        }
    }

    public int getPurchaseCount() {
        return this.purchaseCount;
    }

    public List<LottoNumbers> createLottoNumbers() {
        return Stream.generate(NumbersFactory::createLottoNumbers)
                .limit(this.purchaseCount)
                .collect(Collectors.toList());
    }
}
