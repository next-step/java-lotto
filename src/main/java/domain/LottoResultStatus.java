package domain;

import java.math.BigDecimal;
import java.util.Arrays;

public enum LottoResultStatus {
    NONE(2, 0L),
    WINNING_NUM_3(3, 5_000L),
    WINNING_NUM_4(4, 50_000L),
    WINNING_NUM_5(5, 150_000L),
    WINNING_NUM_6(6, 2_000_000_000L);

    private Integer matchCount;
    private Long winnersPrice;

    LottoResultStatus(Integer matchCount, Long winnersPrice) {
        this.matchCount = matchCount;
        this.winnersPrice = winnersPrice;
    }

    public static LottoResultStatus of(Integer matchCount) {
        return Arrays.stream(LottoResultStatus.values())
                .filter(v -> v.getMatchCount().equals(matchCount))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private Integer getMatchCount() {
        return this.matchCount;
    }

    public static BigDecimal getWinnersPriceByStatus(int matchCount, LottoResultStatus status) {
        return BigDecimal.valueOf(matchCount * status.winnersPrice);
    }

    //TODO :: http://woowabros.github.io/tools/2017/07/10/java-enum-uses.html
}
