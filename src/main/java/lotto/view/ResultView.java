package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.PrizeType.*;

public class ResultView {
    public static void printTickets(LottoTickets lottoTickets) {
        List<Ticket> tickets = lottoTickets.getTickets();
        tickets.forEach(t -> System.out.println(numbersToString(t.getNumbers())));
    }

    public static void printWinningStatus(WinningStatus winningStatus) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + winningStatus.getCountOfPrize(FOURTH_PRIZE) + "개");
        System.out.println("4개 일치 (50000원) - " + winningStatus.getCountOfPrize(THIRD_PRIZE) + "개");
        System.out.println("5개 일치 (1500000원) - " + winningStatus.getCountOfPrize(SECOND_PRIZE) + "개");
        System.out.println("6개 일치 (2000000000원) - " + winningStatus.getCountOfPrize(FIRST_PRIZE) + "개");
    }

    public static void printReturnRate(double returnRate) {
        System.out.println("총 수익률은 " + returnRate + "입니다.");
    }

    private static String numbersToString(List<Integer> numbers) {
        return "[" + numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "))
                + "]";
    }
}
