package lotto.matcher;

import lotto.domain.LottoNumbers;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoMatcher {
    FIRST_PLACE(LottoNumbers.LOTTO_SIZE - 0, false, BigDecimal.valueOf(2_000_000_000)),
    SECOND_PLACE(LottoNumbers.LOTTO_SIZE - 1, true, BigDecimal.valueOf(30_000_000)),
    THIRD_PLACE(LottoNumbers.LOTTO_SIZE - 1, false, BigDecimal.valueOf(1_500_000)),
    FOURTH_PLACE(LottoNumbers.LOTTO_SIZE - 2, false, BigDecimal.valueOf(50_000)),
    FIVE_PLACE(LottoNumbers.LOTTO_SIZE - 3, false, BigDecimal.valueOf(5_000)),
    NONE(0, false, BigDecimal.ZERO);

    private int matchingCount;
    private boolean isMatchBonusBall;
    private BigDecimal price;

    LottoMatcher(int matchingCount, boolean isMatchBonusBall, BigDecimal price) {
        this.matchingCount = matchingCount;
        this.isMatchBonusBall = isMatchBonusBall;
        this.price = price;
    }

    public static LottoMatcher findRanking(int matchCount, boolean matchBonusBall) {
        return Arrays.stream(values())
                .filter(lottoMatcher -> lottoMatcher.matchingCount == matchCount)
                .filter(lottoMatcher -> lottoMatcher.isMatchBonusBall == matchBonusBall)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchingCount() {
        return this.matchingCount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isMatchBonusBall() {
        return isMatchBonusBall;
    }

    public static List<LottoMatcher> findRankingMatchers() {
        return Arrays.stream(values())
                .filter(lottoMatcher -> lottoMatcher != NONE)
                .collect(Collectors.toList());
    }
}
