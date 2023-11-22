package domain.lotto.view;

import domain.lotto.domain.LottoGame;

public class OutputView {

    public static final String BUYING_CONFIRM_QUESTION = "개를 구매했습니다.";

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
            System.out.println(rank.getCountOfMatch() + "개 일치 (" + rank.getWinningMoney() + "원)-" + count + "개");
        });
        System.out.println("총 수익률은 " + String.format("%.2f", lottoGame.getProfitRate()) + " 입니다.");
    }
}
