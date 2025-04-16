package step2.view;

import java.util.Map;

import step2.domain.LottoOrder;
import step2.domain.Rank;

public class OutputView {
    StringBuilder stringBuilder;

    public void printNumbers(LottoOrder lottoOrder) {
        stringBuilder = new StringBuilder();
        stringBuilder.append(lottoOrder.getLottoList().size() + "개를 구매했습니다.\n");
        stringBuilder.append(lottoOrder.getLottoList().getAllLottoNumbers());
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
        if (rank == Rank.NONE) {
            return;
        }
        stringBuilder
            .append(rank.getMatchCount()).append("개 일치 (")
            .append(rank.getPrize()).append("원) - ")
            .append(result.getOrDefault(rank, 0)).append("개\n");
    }

    public void printRate(double rate) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("총 수익률은 " + rate + "입니다.");
        System.out.print(stringBuilder);
    }
}
