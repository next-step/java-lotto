package step3.view;

import java.util.Map;

import step3.domain.LottoOrder;
import step3.domain.Rank;

public class OutputView {
    StringBuilder stringBuilder;

    public void printNumbers(LottoOrder lottoOrder) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(lottoOrder.lottos().size() + "개를 구매했습니다.\n");
        stringBuilder.append(lottoOrder.lottos().allLottoNumbersToString());
        stringBuilder.append("\n");
        System.out.print(stringBuilder);
    }

    public void printResult(Map<Rank, Integer> result) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("당첨 통계\n---------\n");
        for (Rank rank : Rank.values()) {
            appendValidRank(rank, result);
        }
        System.out.print(stringBuilder);
    }

    private void appendValidRank(Rank rank, Map<Rank, Integer> result) {
        if (rank == Rank.MISS) {
            return;
        }
        stringBuilder
            .append(rank.matchCount()).append("개 일치").append(rank == Rank.SECOND ? ", 보너스 볼 일치(" : " (")
            .append(rank.prize()).append("원) - ")
            .append(result.getOrDefault(rank, 0)).append("개\n");
    }

    public void printRate(double rate) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("총 수익률은 " + rate + "입니다.");
        System.out.print(stringBuilder);
    }
}
