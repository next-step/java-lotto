package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoShop {
    private final static int LOTTO_PRICE = 1000;
    private final int DECIMAL_POINT = 2;

    private int price;

    public LottoShop(int price) {
        this.validatePrice(price);
        this.price = price;
    }

    private void validatePrice(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException("The price must be greater than the price of the Lotto");
        }
    }

    public List<LottoNumberResult> buyLotto(LottoNumberGenerator lottoNumberGenerator, List<Integer> allLottoNumber, int size) {
        List<LottoNumberResult> lottoNumbers = new ArrayList<>();
        int purchaseCount = (int) Math.ceil(this.price / LOTTO_PRICE);
        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> lottoNumber = lottoNumberGenerator.generateLottoNumber(allLottoNumber, size);
            lottoNumbers.add(new LottoNumberResult(lottoNumber));
        }
        return lottoNumbers;
    }

    public BigDecimal calculateEarningsRate(List<LottoMatcher> lottoMatchers) {
        BigDecimal amount = BigDecimal.ZERO;
        for (LottoMatcher lottoMatcher : lottoMatchers) {
            amount = amount.add(lottoMatcher.getPrice());
        }

        if (amount.compareTo(BigDecimal.ZERO) == 0) {
            return amount;
        }

        BigDecimal purchaseAmount = new BigDecimal(Math.ceil(price / LOTTO_PRICE) * LOTTO_PRICE);
        return amount.divide(purchaseAmount, DECIMAL_POINT, BigDecimal.ROUND_CEILING);
    }
}
