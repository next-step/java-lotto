package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.List;

public class ResultView {
    private static final String PRIZE_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.2f입니다.";
    private static final String LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private static final int MATCH_THREE = 3;
    private static final int MATCH_FOUR = 4;
    private static final int MATCH_FIVE = 5;
    private static final int MATCH_SIX = 6;

    private static final int PRIZE_MATCH_THREE = 5_000;
    private static final int PRIZE_MATCH_FOUR = 50_000;
    private static final int PRIZE_MATCH_FIVE = 1_500_000;
    private static final int PRIZE_MATCH_SIX = 2_000_000_000;

    public void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        System.out.println(String.format(PRIZE_FORMAT, MATCH_THREE, PRIZE_MATCH_THREE,
                lottoResult.getMatchCount(MATCH_THREE)));

        System.out.println(String.format(PRIZE_FORMAT, MATCH_FOUR, PRIZE_MATCH_FOUR,
                lottoResult.getMatchCount(MATCH_FOUR)));

        System.out.println(String.format(PRIZE_FORMAT, MATCH_FIVE, PRIZE_MATCH_FIVE,
                lottoResult.getMatchCount(MATCH_FIVE)));

        System.out.println(String.format(PRIZE_FORMAT, MATCH_SIX, PRIZE_MATCH_SIX,
                lottoResult.getMatchCount(MATCH_SIX)));
    }

    public void printProfitRate(double profitRate) {
        System.out.print(String.format(PROFIT_RATE_FORMAT, profitRate));

        if (profitRate < 1.0) {
            System.out.println(LOSS_MESSAGE);
        } else {
            System.out.println();
        }
    }
}
