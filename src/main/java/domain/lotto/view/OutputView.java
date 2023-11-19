package domain.lotto.view;

import domain.lotto.domain.LottoGame;

public class OutputView {
    public static final String BUYING_CONFIRM_QUESTION = "개를 구매했습니다.";

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
        System.out.println("3개 일치 (5000원)-" + lottoGame.getLottoStatistics().getMatchThreeCount() + "개\n");
        System.out.println("4개 일치 (50000원)-" + lottoGame.getLottoStatistics().getMatchFourCount() + "개\n");
        System.out.println("5개 일치 (1500000원)-" + lottoGame.getLottoStatistics().getMatchFiveCount() + "개\n");
        System.out.println("6개 일치 (2000000000원)-" + lottoGame.getLottoStatistics().getMatchSixCount() + "개\n");
        System.out.println("총 수익률은 " + String.format("%.2f", lottoGame.getProfitRate()) + " 입니다.");
    }
}
