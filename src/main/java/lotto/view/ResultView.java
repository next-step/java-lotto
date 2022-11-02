package lotto.view;

import lotto.domain.Rank;
import lotto.domain.Ranks;
import lotto.domain.Ticket;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printTicketCount(int manualCount, int autoCount) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualCount, autoCount);
    }

    public static void printTickeList(List<Ticket> ticketList) {
        ticketList.forEach(t -> System.out.println(t.getLottoNumbers()));
    }

    public static void printLottoResult(Ranks ranks) {
        System.out.println("\n당첨 통계\n---------");
        Map<Rank, Integer> rankMap = ranks.getRanks();

        Rank[] rankList = Rank.values();
        for (int i = rankList.length - 2; i >= 0; i--) {
            Rank rank = rankList[i];
            printRank(rank, rankMap);
        }
    }

    private static void printRank(Rank rank, Map<Rank, Integer> rankMap) {

        System.out.printf("%d개 일치%s(%d원)- %d개%n", rank.getMatchCount(), printBonusBallMatch(rank), rank.getMoney(), rankMap.get(rank));
    }

    public static void printIncomePercentage(double incomePercentage) {
        String result = "손해";
        if(incomePercentage > 1){
            result = "이익이";
        }
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", incomePercentage, result);
    }
    private static String printBonusBallMatch(Rank rank) {
        if (rank == Rank.SECOND) {
            return ", 보너스 볼 일치";
        }
        return " ";
    }

    public static void printManualLottoInputGuide(int index) {
        if(index == 0 ){
            System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        }
    }


}
