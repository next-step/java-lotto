package lotto.view;

import lotto.model.Amount;
import lotto.model.PrizeType;
import lotto.model.Statistics;
import lotto.model.Ticket;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ResultView {
    private ResultView() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 티켓 종류 출력
     *
     * @param tickets
     */
    public static void printTicketType(List<Ticket> tickets) {
        long autoNum = getAutoNum(tickets);

        long manualNum = getManualNum(tickets, autoNum);

        StringBuffer sb = new StringBuffer();
        System.out.println();
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualNum, autoNum);
    }

    /**
     * 수동 숫자 구하기
     *
     * @param tickets
     * @param autoNum
     * @return
     */
    private static long getManualNum(List<Ticket> tickets, long autoNum) {
        return tickets.size() - autoNum;
    }

    /**
     * 자동 갯수 구하기
     *
     * @param tickets
     * @return
     */
    private static long getAutoNum(List<Ticket> tickets) {
        return tickets.stream()
                .filter(Ticket::isAuto)
                .count();
    }

    /**
     * 티켓번호들 출력
     *
     * @param tickets
     */
    public static void printTicketNums(List<Ticket> tickets) {
        tickets.stream()
                .map(Ticket::getNums)
                .map(Ticket::toInteger)
                .forEach(nums -> System.out.println(nums.toString()));
    }

    /**
     * 결과 출력
     *
     * @param statistics
     * @param buyAmount
     */
    public static void printResult(Statistics statistics, Amount buyAmount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("----------");

        Arrays.stream(PrizeType.values())
                .filter(PrizeType::isWin)
                .sorted(Comparator.comparing(PrizeType::getPrizeMoney))
                .forEach(p -> {
                    StringBuffer sb = new StringBuffer();
                    sb.append(p.getMatchNum()).append("개 일치");
                    printBonusResult(p, sb);
                    sb.append("(").append(p.getPrizeMoney()).append("원)- ").append(statistics.getMatchGroupNum(p)).append("개");
                    System.out.println(sb.toString());
                });

        System.out.printf("총 수익률은 %.2f 입니다.", statistics.getProfitRate(buyAmount.getOriginalValue()));
    }

    private static void printBonusResult(PrizeType p, StringBuffer sb) {
        if (PrizeType.SECOND.equals(p)) {
            sb.append(", 보너스 볼 일치");
        }
    }
}
