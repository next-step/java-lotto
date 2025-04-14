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
            if (rank == Rank.NONE) {
                continue;
            }
            stringBuilder.append(
                rank.getMatchCount() + "개 일치 (" + rank.getPrize() + "원) - " + result.getOrDefault(rank, 0) + "개\n");
        }
        System.out.print(stringBuilder);
    }

    public void printRate(double rate) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("총 수익률은 " + rate + "입니다.");
        System.out.print(stringBuilder);
    }
}
