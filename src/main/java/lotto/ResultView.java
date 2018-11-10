package lotto;

import java.util.List;

import static java.util.stream.Collectors.toList;

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
                .forEach(nums->{
                    System.out.println(nums.toString());
                });
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
        System.out.println("3개 일치 (5000원)" + statistics.getMatchGroupNum(3) + "개");
        System.out.println("4개 일치 (50000원)" + statistics.getMatchGroupNum(4) + "개");
        System.out.println("5개 일치 (1500000원)" + statistics.getMatchGroupNum(5) + "개");
        System.out.println("6개 일치 (2000000000)" + statistics.getMatchGroupNum(6) + "개");

        System.out.printf("%.2f 입니다.", statistics.getProfitRate(buyAmount) );
    }
}
