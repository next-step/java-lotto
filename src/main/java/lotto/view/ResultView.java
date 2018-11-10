package lotto.view;

import lotto.model.Statistics;
import lotto.model.Ticket;

import java.util.List;

import static lotto.model.Statistics.PRICES;

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
        PRICES.keySet()
                .stream()
                .forEach(matchNum->{
                    StringBuffer sb = new StringBuffer();
                    sb.append(matchNum).append("개 일치 (").append(PRICES.get(matchNum)).append("원)- ")
                            .append(statistics.getMatchGroupNum(matchNum)).append("개");
                    System.out.println(sb.toString());
                });
        System.out.printf("%.2f 입니다.", statistics.getProfitRate(buyAmount) );
    }
}
