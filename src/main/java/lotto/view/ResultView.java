package lotto.view;

import lotto.domain.*;
import lotto.domain.InsightResults;
import lotto.dto.PurchaseResult;

import java.math.BigDecimal;

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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("수동으로 ");
        stringBuilder.append(manualLottos.getLottoCount());
        stringBuilder.append("장, 자동으로 ");
        stringBuilder.append(automaticLottos.getLottoCount());
        stringBuilder.append("장을 구매했습니다.");
        System.out.println(stringBuilder.toString());
    }

    public void viewLottoNumbers(Lotto lotto) {
        StringBuilder stringBuilder = new StringBuilder("[");
        String numbers = lotto.getLottoNumbers().stream()
                .map(LottoNumber::getLottoNumber)
                .map(n -> n.toString())
                .collect(joining(JOIN_DELIMETER));
        stringBuilder.append(numbers);
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }

    public void viewInspect(InsightResults insightResults) {
        System.out.println("\n당첨 통계\n--------------------");
        for (RankEnum rank : insightResults.getInsightResult().keySet()) {
            viewInspectRaw(rank, insightResults.getInsightResult().get(rank));
        }
        System.out.println("\n--------------------");
    }

    private void viewInspectRaw(RankEnum rank, int matchedCount) {
        if (rank.isWinning()) {
            StringBuilder stringBuilder = new StringBuilder(getRankDescription(rank));
            stringBuilder.append(" - ");
            stringBuilder.append(matchedCount);
            stringBuilder.append("개");
            System.out.println(stringBuilder.toString());
        }
    }

    private String getRankDescription(RankEnum rank) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(rank.getMatched());
        stringBuilder.append("개 일치");
        if (rank.getRequiredBonus()) {
            stringBuilder.append(", (보너스 볼 일치)");
        }
        stringBuilder.append("(");
        stringBuilder.append(rank.getReward());
        stringBuilder.append("원)");
        return stringBuilder.toString();
    }

    public void viewRateOfReturn(BigDecimal yield) {
        StringBuilder stringBuilder = new StringBuilder("총 수익률은 ");
        stringBuilder.append(String.format("%.2f", yield));
        stringBuilder.append(" 입니다.");
        System.out.print(stringBuilder.toString());
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
