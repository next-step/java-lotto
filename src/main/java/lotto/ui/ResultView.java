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

    public void showTicketsCounts(LottoGame lottoGame) {
        System.out.printf("%s개를 구매했습니다.%n", lottoGame.getLottoTickets().size());
    }

    public void showEachTicketsLottoNumbers(LottoGame lottoGame) {
        lottoGame.getLottoTickets()
                .forEach(lottoTicket -> System.out.println(convertLottoNumberToInteger(lottoTicket)));
    }

    private List<Integer> convertLottoNumberToInteger(LottoTicket lottoTicket) {
        return lottoTicket.lottoNumbers().stream()
                .mapToInt(LottoNumber::value).boxed()
                .collect(Collectors.toList());
    }

    public void showWinningRateReport(GameResult gameResult) {
        System.out.println("당첨 통계\n---------");

        Arrays.stream(Prize.values())
                .filter(pickPrizesExceptLoser())
                .forEach(prize -> showTicketCountsForGivenPrize(gameResult, prize));

        double profitRate = gameResult.profitRate();
        System.out.printf("총 수익률은 %s 입니다%n", profitRate);
        System.out.printf("(기준이 %s이기 때문에 결과적으로 %s라는 의미임)%n", Gain.BREAK_EVEN_POINT_PROFIT_RATE, Gain.status(profitRate).value());
    }

    private Predicate<Prize> pickPrizesExceptLoser() {
        return prize -> !prize.equals(Prize.LOSER);
    }

    private void showTicketCountsForGivenPrize(GameResult gameResult, Prize prize) {
        if (prize.equals(Prize.SECOND)) {
            System.out.printf("%s개 일치, 보너스 볼 일치(%s원)- %s개%n", prize.winningNumbersCount(), prize.prizeMoney(), gameResult.countTicketsWinning(prize));
            return;
        }
        System.out.printf("%s개 일치 (%s원)- %s개%n", prize.winningNumbersCount(), prize.prizeMoney(), gameResult.countTicketsWinning(prize));
    }

}
