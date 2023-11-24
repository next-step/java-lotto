package domain.lotto.view;

import domain.lotto.domain.LottoGame;
import domain.lotto.domain.Rank;

import java.util.Map;

public class OutputView {

    public static final String BUYING_CONFIRM_QUESTION = "개를 구매했습니다.";

    public static final Map<Rank, String> RANK_DESCRIPTIONS = Map.of(
            Rank.FIRST, "6개 일치 (2000000000원)",
            Rank.SECOND, "5개 일치, 보너스 볼 일치 (30000000원)",
            Rank.THIRD, "5개 일치 (1500000원)",
            Rank.FOURTH, "4개 일치 (50000원)",
            Rank.FIFTH, "3개 일치 (5000원)",
            Rank.MISS, "꽝"
    );

    private OutputView() {
    }

    public static void printBuyingCount(Integer buyingCount) {
        System.out.println(buyingCount + BUYING_CONFIRM_QUESTION);
    }

    public static void printLottoLines(LottoGame lottoGame) {
        lottoGame.getLottoLines()
                .forEach(lottoLine -> System.out.println(lottoLine.getLine()));
    }

    public static void printStatistics(LottoGame lottoGame) {


        System.out.println("당첨 통계\n");
        System.out.println("---------\n");

        lottoGame.getLottoStatistics().getRankCounts().forEach((rank, count) -> {
            System.out.println(RANK_DESCRIPTIONS.get(rank) + "-" + count + "개");
        });
        System.out.println("총 수익률은 " + String.format("%.2f", lottoGame.getProfitRate()) + " 입니다.");
    }
}
