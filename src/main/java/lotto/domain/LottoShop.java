package lotto.domain;

import lotto.generator.LottoNumberGenerator;
import lotto.matcher.LottoMatcher;

import java.math.BigDecimal;
import java.util.List;

public class LottoShop {
    private final static int LOTTO_PRICE = 1000;
    private final int DECIMAL_POINT = 2;

    public LottoShop() {
    }

    public LottoTicket buyLotto(LottoNumberGenerator lottoNumberGenerator, List<Lotto> allLotto, int size) {
        List<Lotto> lotto = lottoNumberGenerator.generateLottoNumber(allLotto, size);
        return new LottoTicket(lotto);
    }

    public BigDecimal calculateEarningsRate(List<LottoMatcher> lottoMatchers, int priceAmount) {
        BigDecimal amount = BigDecimal.ZERO;
        for (LottoMatcher lottoMatcher : lottoMatchers) {
            amount = amount.add(lottoMatcher.getPrice());
        }

        if (amount.compareTo(BigDecimal.ZERO) == 0) {
            return amount;
        }

        BigDecimal purchaseAmount = new BigDecimal( Math.floorDiv(priceAmount, LOTTO_PRICE) * LOTTO_PRICE);
        return amount.divide(purchaseAmount, DECIMAL_POINT, BigDecimal.ROUND_CEILING);
    }

    public int calculatePurchaseCount(int price) {
        return Math.floorDiv(price, LOTTO_PRICE);
    }

    public void availablePurchase(int price) {
        if (LOTTO_PRICE > price) {
            throw new IllegalArgumentException("The price must be greater than the price of the Lotto");
        }
    }
}
