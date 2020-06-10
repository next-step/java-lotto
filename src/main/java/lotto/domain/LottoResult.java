package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class LottoResult {

    private final Map<Rank, Long> matches;

    private LottoResult(Map<Rank, Long> matches) {
        this.matches = matches;
    }

    public static LottoResult of(WinningNumbers winningNumbers, List<Lotto> lottos){
        return new LottoResult(getMatches(winningNumbers, lottos));
    }


    private static Map<Rank, Long> getMatches(WinningNumbers winningNumbers, List<Lotto> lottos) {
        return lottos.stream()
                    .map(winningNumbers::matchWithLotto)
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
