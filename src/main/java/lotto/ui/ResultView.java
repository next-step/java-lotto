package lotto.ui;

import lotto.gameresult.Gain;
import lotto.gameresult.GameResult;
import lotto.gameresult.ProfitRate;
import lotto.number.LottoNumber;
import lotto.ticket.LottoTicket;
import lotto.ticket.Prize;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ResultView {

    public void showTickets(List<LottoTicket> lottoTickets) {
        lottoTickets.forEach(lottoTicket -> System.out.println(convertedType(lottoTicket)));
    }

    public void showTicketCount(int manualsCount, int autosCount) {
        System.out.printf("수동으로 %s장, 자동으로 %s개를 구매했습니다.%n", manualsCount, autosCount);
    }

    private List<Integer> convertedType(LottoTicket lottoTicket) {
        return lottoTicket.lottoNumbers().stream()
                .mapToInt(LottoNumber::value).boxed()
                .collect(Collectors.toList());
    }

    public void showWinningRate(GameResult gameResult) {
        System.out.println("당첨 통계\n---------");

        Arrays.stream(Prize.values())
                .filter(prizeExceptLoser())
                .forEach(prize -> countTicketsPerPrize(gameResult, prize));

        ProfitRate profitRate = gameResult.profitRate();
        System.out.printf("총 수익률은 %.2f 입니다%n", profitRate.value());
        System.out.printf("(기준이 %s이기 때문에 결과적으로 %s라는 의미임)%n", Gain.BREAK_EVEN_POINT_PROFIT_RATE, Gain.status(profitRate).value());
    }

    private Predicate<Prize> prizeExceptLoser() {
        return prize -> !prize.equals(Prize.LOSER);
    }

    private void countTicketsPerPrize(GameResult gameResult, Prize prize) {
        if (prize.equals(Prize.SECOND)) {
            System.out.printf("%s개 일치, 보너스 볼 일치(%s원)- %s개%n", prize.winningNumbersCount(), prize.prizeMoney(), gameResult.countTicketsWinning(prize));
            return;
        }
        System.out.printf("%s개 일치 (%s원)- %s개%n", prize.winningNumbersCount(), prize.prizeMoney(), gameResult.countTicketsWinning(prize));
    }

}
