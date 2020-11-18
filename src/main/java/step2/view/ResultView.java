package step2.view;


import step2.domain.LotteryResult;
import step2.domain.LotteryTickets;
import step2.domain.Rank;

public class ResultView {
    public void responseTicketAndCount(LotteryTickets lotteryTickets) {
        responseTicketCount(lotteryTickets);
        responseTickets(lotteryTickets);
    }

    public void responseTicketCount(LotteryTickets lotteryTickets) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", //
                lotteryTickets.getManualSelectionCount(), lotteryTickets.getNaturalSelectionCount());
    }

    public void responseTickets(LotteryTickets lotteryTickets) {
        lotteryTickets.getTicketNumbers().forEach(System.out::println);
        System.out.println();
    }

    public void responseLotteryResult(LotteryResult lotteryResult) {
        responseWinningStat(lotteryResult);
        responseRateOfReturn(lotteryResult);
    }

    public void responseWinningStat(LotteryResult lotteryResult) {
        //@formatter:off
        System.out.println(
                "\n당첨 통계\n" +
                "---------");
        //@formatter:on
        System.out.println(toStringRank(Rank.FORTH, lotteryResult));
        System.out.println(toStringRank(Rank.THIRD, lotteryResult));
        System.out.println(toStringRank(Rank.SECOND, lotteryResult));
        System.out.println(toStringRank(Rank.FIRST, lotteryResult));
        System.out.println(toStringRank(Rank.FIRST, lotteryResult));
    }

    public static String toStringRank(Rank rank, LotteryResult lotteryResult) {

        return String.format(toFormat(rank), //
                rank.getMatchingCount(),  //
                rank.getPrizeAmount().toInt(), //
                lotteryResult.getMatchResult(rank));
    }

    private static String toFormat(Rank rank) {
        if (rank == Rank.SECOND) {
            return "%d개 일치, 보너스 볼 일치(%d원) - %d개";
        }
        return "%d개 일치 (%d원)- %d개";
    }

    public void responseRateOfReturn(LotteryResult lotteryResult) {
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n", lotteryResult.getRateOfReturn());
    }
}
