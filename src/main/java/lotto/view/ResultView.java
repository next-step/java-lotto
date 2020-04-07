package lotto.view;

import lotto.domain.*;

import java.math.BigDecimal;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class ResultView {
    private static final int BREAK_EVEN_POINT = 1;
    private static final String JOIN_DELIMETER = ", ";

    public ResultView() {

    }

    public void viewLottos(PurchaseResult purchaseResult) {
        viewPurchaseCount(purchaseResult.getManualLottos(), purchaseResult.getAutomaticLottos());
        for (Lotto lotto : purchaseResult.getAllLottos().getLottos()) {
            viewLottoNumbers(lotto);
        }
        System.out.println();
    }

    private void viewPurchaseCount(Lottos manualLottos, Lottos automaticLottos) {
        System.out.println("수동으로 " + manualLottos.getLottoCount() + "장, 자동으로 " + automaticLottos.getLottoCount() + "장을 구매했습니다.");
    }

    public void viewLottoNumbers(Lotto lotto) {
        String numbers = lotto.getLottoNumbers().stream()
                .map(LottoNumber::getLottoNumber)
                .map(n -> n.toString())
                .collect(joining(JOIN_DELIMETER));
        System.out.println("[" + numbers + "]");
    }

    public void viewInspect(InsightResult insightResult) {
        System.out.println("\n당첨 통계\n--------------------");
        for (RankEnum rank : insightResult.getInsightResult().keySet()) {
            viewInspectRaw(rank, insightResult.getInsightResult().get(rank));
        }
        System.out.println("\n--------------------");
    }

    private void viewInspectRaw(RankEnum rank, int matchedCount) {
        if (rank.isWinning()) {
            System.out.println(getRankDescription(rank) + " - " + matchedCount + "개");
        }
    }

    private String getRankDescription(RankEnum rank) {
        String description = rank.getMatched() + "개 일치";
        if (rank.getRequiredBonus()) {
            description += ", (보너스 볼 일치)";
        }
        description += "(" + rank.getReward() + "원)";
        return description;
    }

    public void viewRateOfReturn(BigDecimal yield) {
        System.out.print("총 수익률은 " + String.format("%.2f", yield) + " 입니다.");
        viewRateOfReturnAnalysis(yield.intValue() > BREAK_EVEN_POINT);
    }

    private void viewRateOfReturnAnalysis(boolean isProfit) {
        if (isProfit) {
            System.out.println("(기준이 1이기 때문에 결과적으로 이득이라는 의미임)");
            return;
        }
        System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
