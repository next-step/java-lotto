package lotto.domain;

import java.math.BigDecimal;
import java.util.Arrays;

public enum LottoMatcher {
    FIRST_PLACE(LottoNumbers.LOTTO_SIZE - 0, new BigDecimal(2_000_000_000)),
    SECOND_PLACE(LottoNumbers.LOTTO_SIZE - 1, new BigDecimal(1_500_000)),
    THIRD_PLACE(LottoNumbers.LOTTO_SIZE - 2, new BigDecimal(50_000)),
    FOURTH_PLACE(LottoNumbers.LOTTO_SIZE - 3, new BigDecimal(5_000));

    private int matchingCount;
    private BigDecimal price;

    LottoMatcher(int matchingCount, BigDecimal price) {
        this.matchingCount = matchingCount;
        this.price = price;
    }

    public static LottoMatcher findRanking(int matchCount) {
        return Arrays.stream(values())
                .filter(lottoMatcher -> lottoMatcher.matchingCount == matchCount)
                .findFirst()
                .orElse(null);
    }

    public int getMatchingCount() {
        return this.matchingCount;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
