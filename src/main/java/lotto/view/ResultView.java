package lotto.view;

import lotto.domain.Dto.RankCountDto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSED_BRACKET = "]";
    private static final String DELIMITER = ", ";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String BOUNDARY = "---------";
    private static final String MATCH_BONUS = ", 보너스 볼 일치";
    private static final String BLANK = " ";

    public void purchaseTickets(int manualNumberOfTicket, int autoNumberOfTickets) {
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다%n", manualNumberOfTicket, autoNumberOfTickets);
    }

    public void lottoNumbers(LottoTickets lottotickets) {
        for (LottoTicket lottoTicket : lottotickets.lottoTickets()) {
            String numbers = lottoTicket.lottoNumbers().stream()
                    .map(LottoNumber::lottoNumber)
                    .map(String::valueOf)
                    .collect(Collectors.joining(DELIMITER));
            System.out.println(OPEN_BRACKET + numbers + CLOSED_BRACKET);
        }
    }

    public void statistics(List<RankCountDto> ranksCount) {
        System.out.println();
        System.out.println(WINNING_STATISTICS);
        System.out.println(BOUNDARY);
        for (RankCountDto rankCount : ranksCount) {
            String bonus = bonus(rankCount);
            System.out.printf("%d개 일치%s(%d원)- %d개%n", rankCount.matchedCountStandard(), bonus, rankCount.prize(), rankCount.matchedCountAfterComparison());
        }
    }

    private String bonus(RankCountDto rank) {
        if (rank.hasBonus()) {
            return MATCH_BONUS;
        }

        return BLANK;
    }

    public void positiveProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 이득이라는 의미임)%n", profitRate);
    }

    public void negativeProfitRate(double profitRate) {
        System.out.printf("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n", profitRate);
    }
}
