package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.util.Map;

public class ResultView {

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

    public static void printWinningStatics(Map<Rank, Integer> resultData) {
        StringBuilder builder = new StringBuilder();
        builder.append("당첨 통계")
        .append("\n")
        .append("---------")
        .append("\n");

        Rank[] ranks = Rank.values();
        for(int i = 1; i < ranks.length; i++) {
            Integer matchCount = getMatchCount(resultData.get(ranks[i]));
            builder.append(ranks[i].getCountOfMatch())
                    .append("개 일치 (")
                    .append(ranks[i].getPrizeMoney())
                    .append("원)- ")
                    .append(matchCount)
                    .append("개")
                    .append("\n");
        }

        System.out.print(builder);
    }

    private static Integer getMatchCount(Integer count) {
        if (count == null) {
            return 0;
        }

        return count;
    }

    public static void printRateOfReturn(double profit) {
        System.out.println("총 수익률은 " + profit + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
