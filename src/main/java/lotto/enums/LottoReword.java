package lotto.enums;

import java.util.Arrays;
import java.util.Optional;

public enum LottoReword {
    MISS_MATCH(0, 0, "Miss Match"),
    THREE_MATCH(3, 5_000, "3개 일치 (5000원)"),
    FOUR_MATCH(4, 50_000, "4개 일치 (50000원)"),
    FIVE_MATCH(5, 1_500_000, "5개 일치 (1500000원)"),
    FIVE_AND_BONUS_MATCH(5, 30_000_000, "5개 일치, 보너스 볼 일치(30000000원)"),
    SIX_MATCH(6, 2_000_000_000, "6개 일치 (2000000000원)");

    private final String print;
    private int matchCount;
    private int reword;

    LottoReword(Integer matchCount, int reword, String print) {
        this.matchCount = matchCount;
        this.reword = reword;
        this.print = print;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReword() {
        return reword;
    }

    public String getPrint() {
        return print;
    }

    public static LottoReword valueOf(int matchCount, boolean matchBonus) {
        LottoReword[] lottoRewords = LottoReword.values();
        if(matchBonus && matchCount == FIVE_AND_BONUS_MATCH.matchCount) {
            return LottoReword.FIVE_AND_BONUS_MATCH;
        }

        Optional<LottoReword> lottoRewordOptional = Arrays.asList(lottoRewords)
                .stream()
                .filter(e -> e.matchCount == matchCount)
                .findFirst();
        if(lottoRewordOptional.isPresent()) {
            return lottoRewordOptional.get();
        }

        return MISS_MATCH;
    }

    public int computeReward(int matchCount) {
        return this.reword * matchCount;

    }

}