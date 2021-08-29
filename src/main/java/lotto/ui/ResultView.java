package lotto.ui;

import lotto.game.LottoGame;
import lotto.gameresult.Gain;
import lotto.gameresult.GameResult;
import lotto.number.LottoNumber;
import lotto.ticket.LottoTicket;
import lotto.ticket.Prize;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ResultView {

    public static void showTicketsCounts(LottoGame lottoGame) {
        System.out.printf("%s개를 구매했습니다.%n", lottoGame.getLottoTickets().size());
    }

    public static void showEachTicketsLottoNumbers(LottoGame lottoGame) {
        lottoGame.getLottoTickets()
                .forEach(lottoTicket -> System.out.println(ConvertLottoNumberToInteger(lottoTicket)));
    }

    private static List<Integer> ConvertLottoNumberToInteger(LottoTicket lottoTicket) {
        return lottoTicket.getValue().stream()
                .mapToInt(LottoNumber::value).boxed()
                .collect(Collectors.toList());
    }

    public static void showWinningRateReport(GameResult gameResult) {
        System.out.println("당첨 통계\n---------");

        Arrays.stream(Prize.values())
                .filter(pickPrizesExceptLoser())
                .forEach(prize -> showTicketCountsForGivenPrize(gameResult, prize));

        double profitRate = gameResult.getProfitRate();
        System.out.printf("총 수익률은 %s 입니다%n", profitRate);
        System.out.printf("(기준이 %s이기 때문에 결과적으로 %s라는 의미임)%n", Gain.BREAK_EVEN_POINT_PROFIT_RATE, Gain.decideStatusByProfitRate(profitRate).getValue());
    }

    private static Predicate<Prize> pickPrizesExceptLoser() {
        return prize -> !prize.equals(Prize.LOSER);
    }

    private static void showTicketCountsForGivenPrize(GameResult gameResult, Prize prize) {
        System.out.printf("%s개 일치 (%s원)- %s개%n", prize.getWinningNumbersCounts(), prize.getPrizeMoney(), gameResult.countTicketsWinning(prize));
    }

}
