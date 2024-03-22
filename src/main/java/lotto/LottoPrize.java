package lotto;

import java.util.Arrays;

public enum LottoPrize {

    NONE(0,0),
    MATCH_3(3, 5000),
    MATCH_4(4, 50000),
    MATCH_5(5, 1500000),
    MATCH_6(6, 2000000000);

    private final Integer correctNumber;
    private final Integer prize;

    LottoPrize(Integer correctNumber, Integer prize) {
        this.correctNumber = correctNumber;
        this.prize = prize;
    }

    public static LottoPrize from(int count) {
        return Arrays.stream(values())
                .filter(lottoPrize -> lottoPrize.correctNumber == count)
                .findFirst().orElse(LottoPrize.NONE);
    }

    public String formatPrizeText(long count) {
        return String.format("%d개 일치 (%d원)- %d개\n", this.correctNumber, this.prize, count);
    }

    public int getTotalPrice(long count){
        return prize * (int)count;
    }
}
