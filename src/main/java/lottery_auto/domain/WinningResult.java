package lottery_auto.domain;

import java.util.*;

import lottery_auto.strategy.ProfitRateStrategy;
import lottery_auto.strategy.ProfitRateStrategyImpl;
import lottery_auto.type.WinningMatch;

import java.util.stream.Collectors;

public final class WinningResult {

    private static final ProfitRateStrategy PROFIT_RATE_STRATEGY = new ProfitRateStrategyImpl();

    private final EnumMap<WinningMatch, Integer> matchList = new EnumMap<>(WinningMatch.class);

    public WinningResult(final List<Integer> result) {
        match(result);
    }

    public int compareCnt(WinningMatch winningMatch){
        return matchList.getOrDefault(winningMatch, 0);
    }

    public int sum(){
        return PROFIT_RATE_STRATEGY.calculate(matchList);
    }

    @Override
    public String toString() {
        return matchList.entrySet().stream()
                .map(Objects::toString)
                .collect(Collectors.toList())
                .toString();
    }

    private void match(final List<Integer> match){
        init();
        match.stream()
                .map(WinningMatch::equal)
                .forEach(winningMatch -> matchList.put(winningMatch, matchList.get(winningMatch) + 1));
    }

    private void init(){
        Arrays.stream(WinningMatch.values())
                .forEach(winningMatch -> matchList.put(winningMatch, 0));
    }
}
