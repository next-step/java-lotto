package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;

import java.util.Map;

public class ResultView {

    private ResultView() {
        throw new AssertionError();
    }

    public static void printOrderCount(int manualLottoCount, int autoLottoCount) {

        StringBuilder builder = new StringBuilder();
        builder.append("수동으로 ")
                .append(manualLottoCount)
                .append("장, 자동으로 ")
                .append(autoLottoCount)
                .append("개를 구매했습니다");

        System.out.println(builder);
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

            builder.append(printRank(ranks[i], matchCount));
        }

        System.out.print(builder);
    }

    private static Integer getMatchCount(Integer count) {
        if (count == null) {
            return 0;
        }

        return count;
    }

    private static String printRank(Rank rank, int matchCount) {
        if(rank == Rank.SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%d원)- %d개\n",
                    rank.getCountOfMatch(), rank.getPrizeMoney(), matchCount);
        }

        return String.format("%d개 일치 (%d원)- %d개\n",
                rank.getCountOfMatch(), rank.getPrizeMoney(), matchCount);
    }

    public static void printRateOfReturn(double profit) {
        System.out.println("총 수익률은 " + profit + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
