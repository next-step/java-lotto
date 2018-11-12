package lotto.view;

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
     * 티켓번호들 출력
     *
     * @param tickets
     */
    public static void printTicketNums(List<Ticket> tickets) {
        tickets.stream()
                .map(Ticket::getNums)
                .forEach(nums -> System.out.println(nums.toString()));
    }

    /**
     * 결과 출력
     *
     * @param statistics
     * @param buyAmount
     */
    public static void printResult(Statistics statistics, long buyAmount) {
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

        System.out.printf("총 수익률은 %.2f 입니다.", statistics.getProfitRate(buyAmount));
    }

    private static void printBonusResult(PrizeType p, StringBuffer sb) {
        if (PrizeType.SECOND.equals(p)) {
            sb.append(", 보너스 볼 일치");
        }
    }
}
