package lotto.view;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoBall;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.domain.WinStatistics;

public class ResultView {
    private static final String OUTPUT_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String OUTPUT_STATISTICS_TITLE = "당첨 통계\n---------\n";
    private static final String OUTPUT_NORMAL_MATCH_CASE = "%d개 일치 (%d원) - %d개";
    private static final String OUTPUT_BONUS_MATCH_CASE = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
    private static final String OUTPUT_TOTAL_RATE_OF_RETURN
        = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)\n";

    private static void println(String input) {
        System.out.println(input);
    }

    private static void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    public void outputLottoCount(int lottoCount) {
        System.out.println(lottoCount + OUTPUT_LOTTO_COUNT);
    }

    public void outputLottoLotteries(List<LottoTicket> lottoTickets) {
        int lottoCount = lottoTickets.size();
        outputLottoCount(lottoCount);
        for (LottoTicket lottoTicket : lottoTickets) {
            outputLottoTickets(lottoTicket);
        }
    }

    public void outputLottoTickets(LottoTicket lottoTicket) {
        System.out.println("[" + lottoTicket.toLottoBallSet()
            .stream()
            .map(LottoBall::number)
            .sorted()
            .map(String::valueOf)
            .collect(Collectors.joining(", ")) + "]");
    }

    void outputPrizeStatistics(Rank rank, WinStatistics winStatistics) {
        String prizeStatisticsFormat = OUTPUT_NORMAL_MATCH_CASE;
        if (rank == Rank.SECOND) {
            prizeStatisticsFormat = OUTPUT_BONUS_MATCH_CASE;
        }
        String resultFormat = String.format(prizeStatisticsFormat,
            rank.matchCount(),
            rank.money().amount(),
            winStatistics.result().getOrDefault(rank, 0)
        );
        println(resultFormat);
    }

    public void outputStatistics(WinStatistics winStatistics, float rateOfReturn) {
        println(OUTPUT_STATISTICS_TITLE);
        Rank.getRankList()
            .forEach(rank -> outputPrizeStatistics(rank, winStatistics));
        printf(OUTPUT_TOTAL_RATE_OF_RETURN, rateOfReturn);
    }
}
