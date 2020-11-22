package step04.view;

import step04.Rank;
import step04.domain.Lotto;
import step04.domain.RankCounter;

import java.util.List;

public class ResultView {

    private ResultView() {}
    private static final String LOTTO_BUY_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String HORIZON = "---------";
    private static final String WINNING_STATISTICS_MESSAGE = "%d개 일치 (%d원)- %d개";
    private static final String YIELD_MESSAGE = "총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)";
    private static final String LOSS = "손해";
    private static final String GAIN = "이득";
    private static final String BONUS_BALL_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원)- %d개";
    private static final Integer BONUS_BALL_REWARD = 30_000_000;


    public static void showLottoCount(int lottoCount) {
        System.out.println(lottoCount + LOTTO_BUY_COUNT_MESSAGE);
    }

    public static void showLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }

    public static void showWinningTable(RankCounter rankCounter) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(HORIZON);

        Rank.stream().forEach(rank -> {
            System.out.printf(
                    rank.getWinningMoney() == BONUS_BALL_REWARD ?
                            BONUS_BALL_MESSAGE : WINNING_STATISTICS_MESSAGE,
                rank.getCountOfMatch(),
                rank.getWinningMoney(),
                rankCounter.getCount(rank)
            );
            System.out.println();

        });
    }

    public static void showYield(double yield) {
        String result = yield < 1 ? LOSS : GAIN;
        System.out.printf(YIELD_MESSAGE, yield, result);
    }

}
