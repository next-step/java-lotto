package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class LottoResult {

    private final Map<Rank, Long> matches;

    private LottoResult(Map<Rank, Long> matches) {
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

    private static Map<Rank, Long> getMatches(Set<Integer> winningNumbers, List<Lotto> lottos) {
        return lottos.stream()
                    .map(lotto -> lotto.matchWith(winningNumbers))
                    .filter(match -> !match.equals(Rank.MISS))
                    .collect(groupingBy(Function.identity(), counting()));
    }

    public double getReturnRate(int purchasePrice){
        int sum =  Rank.priceMoneySum(matches);
        return Math.round(((double) sum / purchasePrice) * 100) / 100.0;
    }

    public Map<Rank, Long> getMatches() {
        return Collections.unmodifiableMap(matches);
    }
}
