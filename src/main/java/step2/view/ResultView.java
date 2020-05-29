package step2.view;

import step2.model.LottoRank;
import step2.model.LottoRankCount;
import step2.model.LottoTickets;
import step2.model.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class ResultView {

    private ResultView() {
    }

    public static void printTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getTicketCount() + "장을 구매했습니다.");
        lottoTickets.getAllNumbers().stream()
                .map(Object::toString)
                .forEach(System.out::println);
    }

    public static void printWinningStatistics(LottoTickets lottoTickets, List<Integer> winningNumbers) {
        System.out.println("당첨 통계\n--------------------");
        LottoRankCount lottoRankCount = lottoTickets.calculateLottoRankCount(winningNumbers);
        LottoRank.WINNING_GROUP.forEach(lottoRank -> {
            int matchCount = lottoRankCount.findCount(lottoRank);
            System.out.println(lottoRank.getWinningMoney() + "원 - " + matchCount + "개");
        });
    }

    public static void printRateOfReturn(LottoTickets lottoTickets, List<Integer> winningNumbers, Money money) {
        int winningMoney = lottoTickets.calculateWinningMoney(winningNumbers);

        BigDecimal rateOfReturn = BigDecimal.valueOf(winningMoney)
                .divide(BigDecimal.valueOf(money.getUsedAmount()), 2, RoundingMode.DOWN);

        System.out.println("총 수익률은 " + rateOfReturn + "입니다.");
    }
}
