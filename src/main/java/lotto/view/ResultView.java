package lotto.view;

import lotto.domain.InsightResult;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.RankEnum;

import java.math.BigDecimal;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class ResultView {
    private static final String JOIN_DELIMETER = ", ";

    public ResultView() {

    }

    public void viewLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            viewLottoNumbers(lotto);
        }
        System.out.println();
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
        if (RankEnum.isWinning(rank)) {
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

    public void viewInsight(BigDecimal yield) {
        System.out.print("총 수익률은" + String.format("%.2f", yield) + " 입니다.");
        if (yield.compareTo(new BigDecimal(1)) <= 0) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
            return;
        }
        System.out.println("(기준이 1이기 때문에 결과적으로 이득이라는 의미임)");
    }
}
