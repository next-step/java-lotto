package lottery_bonus.domain;

import lottery_bonus.type.WinningMatch;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public final class WinningResult {

    private static final int MIN_NUMBER = 0;

    private final EnumMap<WinningMatch, Integer> winningMatchMap = new EnumMap<>(WinningMatch.class);

    public WinningResult(final List<Double> scoreList) {
        disposeWinningResult(scoreList);
    }

    public List<Integer> getWinningCountList(){
        List<WinningMatch> winningMatches = WinningMatch.getWinningMatchesExistsNonMatchValue();

        return winningMatches.stream()
                .map(winningMatch -> getMatchCount(winningMatch))
                .collect(Collectors.toList());
    }

    public Double calculateProfit(final BigDecimal amount) {
        return sumMatchCount().divide(amount, 2, BigDecimal.ROUND_FLOOR).doubleValue();
    }

    public Integer getMatchCount(final WinningMatch winningMatch){
        return winningMatchMap.get(winningMatch);
    }

    private void disposeWinningResult(final List<Double> scoreList) {
        init();
        scoreList.stream()
                 .map(WinningMatch::equal)
                 .forEach(winningMatch -> winningMatchMap.put(winningMatch, winningMatchMap.get(winningMatch) + 1));
    }

    private void init() {
        Arrays.stream(WinningMatch.values())
              .forEach(winningMatch -> winningMatchMap.put(winningMatch, 0));
    }

    private boolean validate(final WinningMatch match, final int count) {
        return count > MIN_NUMBER && !match.equals(WinningMatch.MATCH_NON_VALUE);
    }

    private BigDecimal sum(final WinningMatch match, final int count) {
        if(validate(match, count)){
            return match.getWinnings().multiply(new BigDecimal(count));
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal sumMatchCount() {
        return winningMatchMap.entrySet().stream()
                .map(winningMatch -> sum(winningMatch.getKey(), (int) Math.ceil(winningMatch.getValue())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
