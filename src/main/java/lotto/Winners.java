package lotto;

import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import lotto.data.LottoNumbers;
import lotto.data.Lottos;
import lotto.data.Rank;

public class Winners {
    private final Map<Rank, Long> result;

    public Winners(Lottos lottos, LottoNumbers winningNumbers, int bonus) {
        this.result = initResult(lottos, winningNumbers, bonus);
    }

    public long getTotalEarning() {
        int total = 0;

        for (Rank rank : result.keySet()) {
            total += rank.getTotalPrize(result.get(rank));
        }

        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Rank rank : Rank.values()) {
            getResultMessages(sb, rank);
        }

        return sb.toString();
    }

    private Map<Rank, Long> initResult(Lottos lottos, LottoNumbers winningNumbers, int bonus) {
        return getRankList(lottos, winningNumbers, bonus)
                .stream()
                .collect(groupingBy(Function.identity(), Collectors.counting()));
    }

    private List<Rank> getRankList(Lottos lottos, LottoNumbers winningNumbers, int bonus) {
        return lottos.rankLottos(winningNumbers, bonus);
    }

    private void getResultMessages(StringBuilder sb, Rank rank) {
        sb.append(rank.getMatchCount()).append("개 일치, ");

        if (rank.isDependsBonus()) {
            sb.append("보너스볼 일치, ");
        }

        sb.append(rank.getPrize()).append("원 - ")
          .append(result.getOrDefault(rank, 0L)).append("개 당첨\n");
    }
}
