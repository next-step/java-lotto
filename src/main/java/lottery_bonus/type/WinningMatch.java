package lottery_bonus.type;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum WinningMatch {
    MATCH_3(3, "3개 일치", 5_000),
    MATCH_4(4, "4개 일치", 50_000),
    MATCH_5(5, "5개 일치", 1_500_000),
    MATCH_5_BONUS(5.5, "5개 일치, 보너스 볼 일치", 30_000_000),
    MATCH_6(6, "6개 일치", 2_000_000_000),
    MATCH_NON_VALUE(0,"0개 일치", 0);

    private final double score;
    private final String rule;
    private final BigDecimal winnings;

    WinningMatch(double score, String rule, int winnings){
        this.score = score;
        this.rule = rule;
        this.winnings = new BigDecimal(winnings);
    }

    public static WinningMatch equal(double match){
        return Arrays.asList(WinningMatch.values())
                .stream()
                .filter(w-> w.score == match)
                .findAny()
                .orElse(MATCH_NON_VALUE);
    }

    public static List<WinningMatch> getWinningMatchesExistsNonMatchValue(){
        return Arrays.asList(WinningMatch.values())
                .stream()
                .filter(winningMatch -> winningMatch != WinningMatch.MATCH_NON_VALUE)
                .collect(Collectors.toList());
    }

    public String getRule() {
        return rule;
    }

    public BigDecimal getWinnings() {
        return winnings;
    }

    @Override
    public String toString() {
        return String.valueOf(score);
    }
}
