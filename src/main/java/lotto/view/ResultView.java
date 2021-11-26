package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.util.Map;

public class ResultView {

    public static final int LOTTO_START_COUNT = 3;
    public static final int LOTTO_END_COUNT = 6;

    private ResultView() {}

    public static void printOrderCount(int orderCount) {
        System.out.println(orderCount + "개를 구매했습니다");
    }

    public static void printOrderLottoNumber(LottoTicket lottoTicket) {
        lottoTicket.getLotto().stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printWinningStatics(Map<Integer, Integer> countOfMatch) {
        StringBuilder builder = new StringBuilder();
        builder.append("당첨 통계");
        builder.append("\n");
        builder.append("---------");
        builder.append("\n");
        for (int count = LOTTO_START_COUNT; count <= LOTTO_END_COUNT; count++) {
            Rank rank = Rank.valueOf(count);
            builder.append(count);
            builder.append("개 일치(");
            builder.append(rank.getPrizeMoney());
            builder.append("원) - ");
            int value = countOfMatch.get(count);
            builder.append(value);
            builder.append("개");
            builder.append("\n");
        }
        System.out.print(builder);
    }

    public static void printRateOfReturn(double profit) {
        System.out.println("총 수익률은 " + profit + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
