package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class LottoResult {

    private final Map<Match, Long> matches;

    private LottoResult(Map<Match, Long> matches) {
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

    private static Map<Match, Long> getMatches(Set<Integer> winningNumbers, List<Lotto> lottos) {
        return lottos.stream()
                    .map(lotto -> lotto.matchWith(winningNumbers))
                    .filter(match -> !match.equals(Match.NONE))
                    .collect(groupingBy(Function.identity(), counting()));
    }

    public double getReturnRate(int purchasePrice){
        int sum =  Match.priceMoneySum(matches);
        return Math.round(((double) sum / purchasePrice) * 100) / 100.0;
    }

    public Map<Match, Long> getMatches() {
        return Collections.unmodifiableMap(matches);
    }
}
