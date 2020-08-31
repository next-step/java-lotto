package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static final String LOTTO_COUNT_OUTPUT = "%d개를 구매했습니다.";
    public static final String GUIDELINE_FOR_WINNING = "\n당첨 통계\n--------";
    public static final String WINNING_COUNT_OUTPUT = "%d개 일치%s(%d원)- %d개";
    public static final String PROFIT_RATE_OUTPUT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private ResultView() {
        throw new AssertionError();
    }

    public static void printLottoCount(int lottoPrice) {
        System.out.println(String.format(LOTTO_COUNT_OUTPUT, lottoPrice));
    }

    public static void printLottoNumber(List<Lotto> lottoList) {
        lottoList.forEach(lotto -> System.out.println(lotto.getLotto()));
    }

    public static void printWinningCount(Map<Integer, Long> rankCount, int lottoPrice) {
        System.out.println(GUIDELINE_FOR_WINNING);

        float sum = 0;
        Rank rank;
        long count;
        long money;
        for (int i = 4; i >= 0; i--) {
            checkHashMap(rankCount, i);
            count = rankCount.get(i);
            rank = Rank.valueOf(i);
            money = rank.getWinningMoney();
            System.out.println(String.format(WINNING_COUNT_OUTPUT, rank.getCountOfMatch(), rank.isBonusMatch(), money, count));
            sum += money * count;
        }

        System.out.println(String.format(PROFIT_RATE_OUTPUT, sum / lottoPrice));

    }

    private static void checkHashMap(Map<Integer, Long> winningCount, long index) {
        if (!winningCount.containsKey((int) index)) {
            winningCount.put((int) index, 0L);
        }
    }

}
