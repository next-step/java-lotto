package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.PrizeType.*;

public class ResultView {
    public static void printTickets(LottoTickets lottoTickets) {
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.\n", lottoTickets.getNumberOfManualTickets(), lottoTickets.getNumberOfAutoTickets());
        List<Ticket> tickets = lottoTickets.getTickets();
        tickets.forEach(t -> System.out.println(numbersToString(t.getNumbers())));
    }

    public static void printWinningStatus(WinningStatus winningStatus) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3개 일치 (5000원) - " + winningStatus.countOfPrize(FIFTH_PRIZE) + "개");
        System.out.println("4개 일치 (50000원) - " + winningStatus.countOfPrize(FOURTH_PRIZE) + "개");
        System.out.println("5개 일치 (1500000원) - " + winningStatus.countOfPrize(THIRD_PRIZE) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + winningStatus.countOfPrize(SECOND_PRIZE) + "개");
        System.out.println("6개 일치 (2000000000원) - " + winningStatus.countOfPrize(FIRST_PRIZE) + "개");
    }

    public static void printReturnRate(double returnRate) {
        System.out.println("총 수익률은 " + returnRate + "입니다.");
    }

    private static String numbersToString(List<LottoNo> numbers) {
        return "[" + numbers.stream()
                .map(lottoNo -> Integer.toString(lottoNo.number()))
                .collect(Collectors.joining(", "))
                + "]";
    }
}
