package lotto.view;

import lotto.dto.LottoTicketDto;
import lotto.prize.LottoPrizeTemp;
import lotto.prize.MatchResult;

import java.util.Arrays;
import java.util.List;

public class ResultView {
    private static final String BUY_RESULT_STATEMENT_FORMAT = "%d 개를 구매했습니다.";
    private static final String WINNING_PRIZE_STATISTICS_STATEMENT = "당첨 통계" + System.lineSeparator() + "----------";
    private static final String PRIZE_RESULT_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String SECOND_PRIZE_RESULT_FORMAT = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
    private static final String EARNINGS_RATE_FORMAT = "총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private ResultView() {}

    public static void printLottoTickets(List<LottoTicketDto> lottoTickets) {
        printStatement(String.format(BUY_RESULT_STATEMENT_FORMAT, lottoTickets.size()));

        lottoTickets.stream()
                .map(LottoTicketDto::getNumbers)
                .map(List::toArray)
                .map(Arrays::toString)
                .forEach(ResultView::printStatement);
    }

    public static void printMatchResult(MatchResult matchResult) {
        printStatement(WINNING_PRIZE_STATISTICS_STATEMENT);

        LottoPrizeTemp.getWinningPrizes()
                .forEach(lottoPrize -> printPrizeResult(lottoPrize, matchResult));

        printStatement(String.format(EARNINGS_RATE_FORMAT, matchResult.calculateEarningsRate()));
    }

    private static void printPrizeResult(LottoPrizeTemp lottoPrize, MatchResult matchResult) {
        String resultFormat = lottoPrize == LottoPrizeTemp.SECOND ?
                SECOND_PRIZE_RESULT_FORMAT :
                PRIZE_RESULT_FORMAT;

        String result = String.format(
                resultFormat,
                lottoPrize.getMatchCount(),
                lottoPrize.getPrizeMoney().toInt(),
                matchResult.matchCount(lottoPrize)
        );

        printStatement(result);
    }


    private static void printStatement(String statement) {
        System.out.println(statement);
    }
}
