package lotto.ui;

import lotto.game.LottoGame;
import lotto.gameresult.Gain;
import lotto.gameresult.GameResult;
import lotto.number.LottoNumber;
import lotto.ticket.LottoTicket;
import lotto.ticket.Prize;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ResultView {

    public static void showTicketsCounts(LottoGame lottoGame) {
        System.out.println(lottoGame.getLottoTickets().size() + "개를 구매했습니다.");
    }

    public static void showEachTicketsLottoNumbers(LottoGame lottoGame) {
        lottoGame.getLottoTickets().forEach(showLottoNumbers());
        goToNewLine();
    }

    private static Consumer<LottoTicket> showLottoNumbers() {
        return lottoTicket -> System.out.println(ConvertLottoNumberToInteger(lottoTicket));
    }

    private static List<Integer> ConvertLottoNumberToInteger(LottoTicket lottoTicket) {
        return lottoTicket.getValue().stream().mapToInt(LottoNumber::getValue).boxed().collect(Collectors.toList());
    }

    public static void showNumberOfTicketsWinningPrize(GameResult gameResult) {
        printTitle();
        drawLineOfDashes();
        showTicketsCountsForEachPrize(gameResult);
    }

    public static void showProfitRateAndGain(GameResult gameResult) {
        double profitRate = gameResult.getProfitRate();
        showProfitRate(profitRate);
        showGain(profitRate);
    }

    private static void showGain(double profitRate) {
        System.out.println("(기준이 " + Gain.BREAK_EVEN_POINT_PROFIT_RATE + "이기 때문에 결과적으로 " + Gain.decideStatusByProfitRate(profitRate).getValue() + "라는 의미임)");
    }

    private static void showProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "입니다.");
    }

    private static void printTitle() {
        System.out.println("당첨 통계");
    }

    private static void drawLineOfDashes() {
        System.out.println("---------");
    }

    private static void showTicketsCountsForEachPrize(GameResult gameResult) {
        Arrays.stream(Prize.values())
                .filter(pickPrizesExceptLoser())
                .forEach(prize -> showTicketCountsForGivenPrize(gameResult, prize));
    }

    private static Predicate<Prize> pickPrizesExceptLoser() {
        return prize -> !prize.equals(Prize.LOSER);
    }

    private static void showTicketCountsForGivenPrize(GameResult gameResult, Prize prize) {
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

    private static void showNumberOfTickets(GameResult gameResult, Prize prize) {
        System.out.print("- " + gameResult.countTicketsWinning(prize) + "개");
    }

    private static void goToNewLine() {
        System.out.println();
    }
}
