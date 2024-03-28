package lotto.match;

import lotto.prize.LottoPrize;

public class LottoPrizeCount {
    private final LottoPrize lottoPrize;
    private final long count;

    private static final String BASE_WORD = "%d개 일치%s (%d원) - %d개";
    private static final String BONUS_WORD = ",보너스 볼 일치";

    public LottoPrizeCount(LottoPrize lottoPrize, long count) {
        this.lottoPrize = lottoPrize;
        this.count = count;
    }

    public String getWord() {
        String bonusWord = getBonusPart();
        return String.format(BASE_WORD, lottoPrize.getCorrectNumber(), bonusWord, lottoPrize.getPrize(), count);
    }

    private String getBonusPart(){
        if(this.lottoPrize.getIsBonus())
            return BONUS_WORD;
        return "";
    }
}