package lotto.views;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningTable;

import java.util.List;
import java.util.Map;

public class ResultView {

    private ResultView() { }

    public static void showWinningResult(LottoResult lottoResult) {
        StringBuilder stringBuilder = new StringBuilder()
                .append("\n당첨 통계\n---------\n");

        for (Map.Entry<String, Integer> entry: lottoResult.resultMap().entrySet()) {
            stringBuilder.append(WinningTable.valueOf(entry.getKey()).description)
            .append("- ")
            .append(entry.getValue())
            .append("개\n");
        }
        stringBuilder.append("총 수익률은 ")
                .append(String.format("%.2f", lottoResult.yield()))
                .append(" 입니다.");
        System.out.println(stringBuilder.toString());
    }

    public static void showPurchaseLotto(List<Lotto> lottos) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(lottos.size())
                .append("개를 구매했습니다.\n");
        lottos.forEach(lotto -> stringBuilder.append(lotto.toString()).append("\n"));
        System.out.println(stringBuilder.toString() + "\n");
    }
}
