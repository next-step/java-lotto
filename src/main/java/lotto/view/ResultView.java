package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.util.Map;

public class ResultView {

    public static final int LOTTO_START_COUNT = 3;
    public static final int LOTTO_END_COUNT = 6;

    private ResultView() {
        throw new AssertionError();
    }

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
        builder.append("당첨 통계")
        .append("\n")
        .append("---------")
        .append("\n");
        for (int count = LOTTO_START_COUNT; count <= LOTTO_END_COUNT; count++) {
            Rank rank = Rank.valueOf(count);
            builder.append(count)
            .append("개 일치(")
            .append(rank.getPrizeMoney())
            .append("원) - ")
            .append(countOfMatch.get(count))
            .append("개")
            .append("\n");
        }
        System.out.print(builder);
    }

    public static void printRateOfReturn(double profit) {
        System.out.println("총 수익률은 " + profit + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
