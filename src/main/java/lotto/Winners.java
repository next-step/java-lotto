package lotto;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import lotto.data.LottoNumbers;
import lotto.data.Lottos;
import lotto.data.Rank;

public class Winners {
    private final Map<Rank, Long> result;

    public Winners(Lottos lottos, LottoNumbers winningNumbers) {
        this.result = initResult(lottos, winningNumbers);
    }

    public Map<Rank, Long> getResult() {
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Rank rank : Rank.values()) {
            sb.append(rank.getMatchCount()).append("개 일치 : ")
              .append(rank.getPrize()).append("원 - ")
              .append(result.getOrDefault(rank, 0L)).append("개 당첨\n");
        }

        return sb.toString();
    }

    public long totalEarning() {
        int total = 0;

        for (Rank rank : result.keySet()) {
            total += result.get(rank) * rank.getPrize();
        }

        return total;
    }

    private Map<Rank, Long> initResult(Lottos lottos, LottoNumbers winningNumbers) {
        return getRankList(lottos, winningNumbers)
                .stream()
                .collect(groupingBy(Function.identity(), Collectors.counting()));
    }

    private List<Rank> getRankList(Lottos lottos, LottoNumbers winningNumbers) {
        return lottos.getLottos().stream()
              .map(lotto -> lotto.matchCount(winningNumbers))
              .map(Rank::valueOf)
              .collect(toList());
    }
}
