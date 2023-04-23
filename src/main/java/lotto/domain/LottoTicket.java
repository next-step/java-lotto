package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private final List<LottoNumber> lottoNumbers;
    private Map<Rank, Long> rankCounts = new HashMap<>();

    public LottoTicket(int lottoCount) {
        this.lottoNumbers = createLotto(lottoCount);
    }

    private List<LottoNumber> createLotto(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> new LottoNumber())
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public void setRankCounts(List<Integer> winningNumbers) {
        rankCounts = lottoNumbers.stream()
                .map(lottoNumber -> lottoNumber.countMatchingNumbers(winningNumbers))
                .map(Rank::valueOf)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public long findRankCount(int matchCount) {
        return rankCounts.getOrDefault(Rank.valueOf(matchCount), 0L);
    }

}
