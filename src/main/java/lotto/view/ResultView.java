package lotto.view;

import lotto.domain.Rank;
import lotto.domain.Ranks;
import lotto.domain.Ticket;

import java.util.EnumMap;
import java.util.List;

public class ResultView {
    public static void printTicketCount(int ticketCount) {
        System.out.printf("%d개를 구매했습니다.\n", ticketCount);
    }

    public static void printTickeList(List<Ticket> ticketList) {
        ticketList.forEach(t -> System.out.println(t.getLottoNumbers()));
    }

    public static void printLottoResult(Ranks ranks) {
        System.out.println("\n당첨 통계\n---------");
        EnumMap<Rank, Integer> rankMap = ranks.getRanks();

        printRank(Rank.FOURTH, rankMap);
        printRank(Rank.THIRD, rankMap);
        printRank(Rank.SECOND, rankMap);
        printRank(Rank.FIRST, rankMap);
    }

    private static void printRank(Rank rank, EnumMap<Rank, Integer> rankMap) {
        System.out.printf("%d개 일치 (%d원)- %d개%n", rank.getMatchCount(), rank.getMoney(), rankMap.get(rank));
    }

    public static void printIncomePercentage(double incomePercentage) {
        String result = "손해";
        if(incomePercentage > 1){
            result = "이익이";
        }
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", incomePercentage, result);
    }
}
