package lotto.view;

import lotto.model.PrizeMoneyType;
import lotto.model.Statistics;
import lotto.model.Ticket;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private ResultView() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 티켓번호들 출력
     * @param tickets
     */
    public static void printTicketNums(List<Ticket> tickets) {
        tickets.stream()
                .map(Ticket::getNums)
                .forEach(nums->System.out.println(nums.toString()));
    }

    /**
     * 결과 출력
     * @param statistics
     * @param buyAmount
     */
    public static void printResult(Statistics statistics, Integer buyAmount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("----------");

        Arrays.stream(PrizeMoneyType.values())
                .forEach(p ->{
                    StringBuffer sb = new StringBuffer();
                    sb.append(p.getMatchNum()).append("개 일치 (").append(p.getPrizeMoney()).append("원)- ")
                            .append(statistics.getMatchGroupNum(p.getMatchNum())).append("개");
                    System.out.println(sb.toString());
                });

        System.out.printf("%.2f 입니다.", statistics.getProfitRate(buyAmount) );
    }
}
