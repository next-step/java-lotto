package lotto.view;

import lotto.domain.Lotto;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static final String LOTTO_COUNT_OUTPUT = "%d개를 구매했습니다.";
    public static final String GUIDELINE_FOR_WINNING = "\n당첨 통계\n--------";
    public static final String WINNING_COUNT_OUTPUT = "%d개 일치 (%d원)- %d개";
    public static final String PROFIT_RATE_OUTPUT = "총 수익률은 %f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private ResultView() {
        throw new AssertionError();
    }

    public static void printLottoCount(int lottoPrice) {
        System.out.println(String.format(LOTTO_COUNT_OUTPUT, lottoPrice));
    }

    public static void printLottoNumber(List<Lotto> lottoList) {
        lottoList.forEach(lotto -> System.out.println(lotto.getLotto()));
    }

    public static void printWinningCount(Map<Integer, Long> winningCount, int lottoPrice) {
        System.out.println(GUIDELINE_FOR_WINNING);
        int[] winningMoney = {5000, 50000, 1500000, 2000000000};

        float sum = 0;
        for (int i = 3; i < 7; i++) {
            System.out.println(String.format(WINNING_COUNT_OUTPUT, i, winningMoney[i - 3], winningCount.get(i)));
            sum += winningMoney[i - 3] * winningCount.get(i);
        }

        System.out.println(String.format(PROFIT_RATE_OUTPUT, sum / lottoPrice));
    }
}
