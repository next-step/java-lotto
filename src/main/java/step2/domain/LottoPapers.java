package step2.domain;

import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoPapers {
    private final List<LottoPaper> lottoPapers;

    public LottoPapers(List<LottoPaper> lottoPapers) {
        this.lottoPapers = lottoPapers;
    }

    public List<LottoPaper> getLottoPapers() {
        return lottoPapers;
    }

    public LottoPapers merge(LottoPapers targetLottoPapers) {
        List<LottoPaper> mergedLottoPapers = Stream.of(this.lottoPapers, targetLottoPapers.getLottoPapers())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return new LottoPapers(mergedLottoPapers);
    }

    public CountsByRank groupByRank(LottoPaper winLottoPaper, LottoNumber bonusLottoNumber) {
        TreeMap<Rank, Long> countsByRank = this.lottoPapers.stream()
                .map(lottoNumber -> {
                    int countOfMath = lottoNumber.compareMatch(winLottoPaper);
                    boolean matchBonus = lottoNumber.isInclude(bonusLottoNumber);
                    return Rank.valueOf(countOfMath, matchBonus);
                })
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        TreeMap::new,
                        Collectors.counting()
                ));
        return new CountsByRank(countsByRank);
    }

    public int size() {
        return lottoPapers.size();
    }
}
