package lotto;

import java.util.List;

public class OutputView {

    private static final String BONUS_BALL = ", 보너스 볼 일치";
    private static final String LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---------";
    private static final int ZERO = 0;
    private static final int HUNDRED = 100;

    public static int getLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
        return count;
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

}
