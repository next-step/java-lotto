package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoResult {

    private final List<Match> matches;

    private LottoResult(List<Match> matches) {
        this.matches = matches;
    }

    public static LottoResult of(Set<Integer> winningNumbers, List<Lotto> lottos){
        validationCheck(winningNumbers);
        return new LottoResult(getMatches(winningNumbers, lottos));
    }

    private static void validationCheck(Set<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6자여야 합니다.");
        }
    }

    private static List<Match> getMatches(Set<Integer> winningNumbers, List<Lotto> lottos) {
        return lottos.stream()
                    .map(lotto -> lotto.matchWith(winningNumbers))
                    .filter(match -> !match.equals(Match.NONE))
                    .collect(Collectors.toList());
    }

    public Map<Match, Integer> getMatchResult(){
        Map<Match, Integer> map = new HashMap<>();
        matches.stream()
                .filter(match -> !match.equals(Match.NONE))
                .forEach(match -> map.put(match, map.getOrDefault(match, 0) + 1));
        return map;
    }

    public double getReturnRate(int purchasePrice){
        int sum =  Match.priceMoneySum(matches);
        return Math.round(((double) sum / purchasePrice) * 100) / 100.0;
    }

    public List<Match> getMatches() {
        return matches;
    }
}
