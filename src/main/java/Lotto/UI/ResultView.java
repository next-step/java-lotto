package Lotto.UI;

import Lotto.Game.ExpectedGameResult;
import Lotto.Number.LottoNumber;
import Lotto.Ticket.LottoTicket;
import Lotto.Ticket.Prize;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ResultView {

    public static void showTotalNumberOfPurchasedLottoTickets(int totalNumber) {
        System.out.println(totalNumber + "개를 구매했습니다.");
    }

    public static void showLottoNumbersOfEachTickets(List<LottoTicket> lottoTickets) {
        lottoTickets.forEach(showLottoNumbers());
        goToNewLine();
    }

    private static Consumer<LottoTicket> showLottoNumbers() {
        return lottoTicket -> System.out.println(ConvertLottoNumberToInteger(lottoTicket));
    }

    private static List<Integer> ConvertLottoNumberToInteger(LottoTicket lottoTicket) {
        return lottoTicket.getValue().stream().mapToInt(LottoNumber::getValue).boxed().collect(Collectors.toList());
    }

    public static void showNumberOfTicketsExpectedToWinPrize(ExpectedGameResult gameResult) {
        printTitle();
        goToNewLine();
        drawLineOfDashes();
        showTicketsCountsForEachPrize(gameResult);

        // TODO 수익률 도출

        /*3개 일치 (5000원)- 1개
            4개 일치 (50000원)- 0개
            5개 일치 (1500000원)- 0개
            6개 일치 (2000000000원)- 0개
            총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)*/
    }

    public static void showExpectedProfitRate(ExpectedGameResult gameResult) {
        // double profitRate = gameResult.getProfitRate();
        System.out.println("총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임");
    }

    private static void printTitle() {
        System.out.println("당첨 통계");
    }

    private static void drawLineOfDashes() {
        System.out.println("---------");
    }

    private static void showTicketsCountsForEachPrize(ExpectedGameResult gameResult) {
        Arrays.stream(Prize.values()).forEach(prize -> showTicketCountsForGivenPrize(gameResult, prize));
    }

    private static void showTicketCountsForGivenPrize(ExpectedGameResult gameResult, Prize prize) {
        showMatchingNumbers(prize);
        showPrizeMoney(prize);
        showNumberOfTickets(gameResult, prize);
        goToNewLine();
    }

    private static void showMatchingNumbers(Prize prize) {
        System.out.print(prize.getWinningNumbersCounts() + "개 일치 ");
    }

    private static void showPrizeMoney(Prize prize) {
        System.out.print("(" + prize.getPrizeMoney() + "원)");
    }

    private static void showNumberOfTickets(ExpectedGameResult gameResult, Prize prize) {
        System.out.print("- " + gameResult.countTicketsWinning(prize) + "개");
    }

    private static void goToNewLine() {
        System.out.println();
    }
}
