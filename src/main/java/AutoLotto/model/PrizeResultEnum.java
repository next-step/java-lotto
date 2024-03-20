package autoLotto.model;

import java.util.Arrays;

public enum PrizeResultEnum {
    THREE_MATCHED(1, "3개 일치 (5,000원) - ", 5000L),
    FOUR_MATCHED(2, "4개 일치 (50,000원) - ", 50000L),
    FIVE_MATCHED(3, "5개 일치 (1,500,000원) - ", 1500000L),
    SIX_MATCHED(4, "6개 일치 (2,000,000,000원) - ", 2000000000L);

    private int index;
    private String description;
    private Long prize;

    PrizeResultEnum(int index, String description, Long prize) {
        this.index = index;
        this.description = description;
        this.prize = prize;
    }

    private String getDescription(){
        return description;
    }

    private Long getPrize() {
        return prize;
    }

    public static String getDescriptionByIndex(int index) {
        return Arrays.stream(values())
                .filter(prizeResult -> prizeResult.index == index)
                .findFirst()
                .map(PrizeResultEnum::getDescription)
                .orElse(null);
    }

    public static Long getPrizeByIndex(int index) {
        return Arrays.stream(values())
                .filter(prizeResult -> prizeResult.index == index)
                .findFirst()
                .map(PrizeResultEnum::getPrize)
                .orElse(null);
    }
}
