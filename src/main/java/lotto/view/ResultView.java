package lotto.view;

import com.google.common.base.Function;
import lotto.model.LottoNum;
import lotto.model.PrizeType;
import lotto.model.Statistics;
import lotto.model.Ticket;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private ResultView() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * 티켓 종류 출력
     *
     * @param manualNum
     * @param autoNum
     */
    public static void printTicketType(int manualNum, int autoNum) {
        StringBuffer sb = new StringBuffer();
        System.out.println();
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", manualNum, autoNum);
    }

    /**
     * 티켓번호들 출력
     *
     * @param tickets
     */
    public static void printTicketNums(List<Ticket> tickets) {
        Ticket.getTicketsNums(tickets).stream()
                .forEach(t -> System.out.println(t));
    }

    /**
     * 결과 출력
     *
     * @param statistics
     * @param profitRate
     */
    public static void printResult(Statistics statistics, Function<Integer, Double> profitRate) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("----------");
        getResult(statistics).forEach(s -> System.out.println(s));
        System.out.printf("총 수익률은 %.2f 입니다.", profitRate.apply(statistics.getProfit()));
    }

    private static void printBonusResult(Function<PrizeType, Boolean> bonusFunc, PrizeType p, StringBuffer sb) {
        if (bonusFunc.apply(p)) {
            sb.append(", 보너스 볼 일치");
        }
    }

    /**
     * 결과 가져오기
     * @param statistics
     * @return
     */
    public static List<String> getResult(Statistics statistics) {
        return Arrays.stream(PrizeType.values())
                .filter(PrizeType::isWin)
                .sorted(Comparator.comparing(PrizeType::getPrizeMoney))
                .map(p -> {
                    StringBuffer sb = new StringBuffer();
                    sb.append(p.getMatchNum()).append("개 일치");
                    printBonusResult(PrizeType.SECOND::equals, p, sb);
                    sb.append("(").append(p.getPrizeMoney()).append("원)- ").append(statistics.getMatchGroupNum(p)).append("개");
                    return sb.toString();
                })
                .collect(Collectors.toList());
    }
}
