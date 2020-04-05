package step2.domain;

import java.util.Arrays;

public enum LottoWinningInfomation {
    FIRST(LottoConstant.FIRST_DESCRPTION, 6, 2000000000),
    SECOND(LottoConstant.SECOND_DESCRPTION, 5, 1500000),
    THIRD(LottoConstant.THIRD_DESCRPTION, 4, 50000),
    FOURTH(LottoConstant.FOURTH_DESCRPTION, 3, 5000);

    private final String description;
    private final int matchCount;
    private final int price;

    public String getDescription() {
        return description;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getPrice() {
        return this.price;
    }

    LottoWinningInfomation(String description, int matchCount, int price) {
        this.description = description;
        this.matchCount = matchCount;
        this.price = price;
    }

    public static LottoWinningInfomation matchCountInformation(int matchCount) {
        return Arrays.asList(values())
                .stream()
                .filter(count -> count.matchCount == matchCount)
                .findFirst()
                .orElse(null);
    }
}
