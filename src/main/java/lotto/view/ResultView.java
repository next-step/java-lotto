package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoBall;
import lotto.domain.LottoBalls;
import lotto.domain.Rank;
import lotto.domain.WinStatistics;

public class ResultView {
    private static final String OUTPUT_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String OUTPUT_STATISTICS_TITLE = "당첨 통계\n---------\n";
    private static final String OUTPUT_THREE_MATCH_CASE = "3개 일치 (5000원)- %d개\n";
    private static final String OUTPUT_FOUR_MATCH_CASE = "4개 일치 (50000원)- %d개\n";
    private static final String OUTPUT_FIVE_MATCH_CASE = "5개 일치 (1500000원)- %d개\n";
    private static final String OUTPUT_SIX_MATCH_CASE = "6개 일치 (2000000000)- %d개\n";
    private static final String OUTPUT_TOTAL_RATE_OF_RETURN
        = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n";

    public void outputLottoCount(int lottoCount) {
        System.out.println(lottoCount + OUTPUT_LOTTO_COUNT);
    }

    public void outputLottoLotteries(List<LottoBalls> lottoTickets) {
        int lottoCount = lottoTickets.size();
        outputLottoCount(lottoCount);
        for (LottoBalls lottoBalls : lottoTickets) {
            outputLottoTickets(lottoBalls);
        }
    }

    public void outputLottoTickets(LottoBalls lottoBalls) {
        System.out.println("[" + lottoBalls.toLottoBallSet()
            .stream()
            .map(LottoBall::number)
            .map(String::valueOf)
            .collect(Collectors.joining(", ")) + "]");
    }

    public void outputStatistics(WinStatistics winStatistics, float rateOfReturn) {
        println(OUTPUT_STATISTICS_TITLE);
        printf(OUTPUT_THREE_MATCH_CASE, winStatistics.countByRank(Rank.FOURTH_RANK));
        printf(OUTPUT_FOUR_MATCH_CASE, winStatistics.countByRank(Rank.THIRD_RANK));
        printf(OUTPUT_FIVE_MATCH_CASE, winStatistics.countByRank(Rank.SECOND_RANK));
        printf(OUTPUT_SIX_MATCH_CASE, winStatistics.countByRank(Rank.FIRST_RANK));
        printf(OUTPUT_TOTAL_RATE_OF_RETURN, rateOfReturn);
    }

    private static void println(String input) {
        System.out.println(input);
    }

    private static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }
}
