package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.dto.LottoResult;
import lotto.domain.model.result.LottoRank;
import lotto.dto.LottoTicketDto;

public class ResultView {

    public static final String NEWLINE = System.lineSeparator();
    public static final String TICKET_HEADER_TEMPLATE = NEWLINE + "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    public static final String RESULT_HEADER = NEWLINE + "당첨 통계" + NEWLINE + "---------";
    public static final String RANK_RESULT_TEMPLATE = "%d개 일치 (%d원)";
    public static final String RANK_SECOND_RESULT_TEMPLATE = "%d개 일치, 보너스 볼 일치(%d원)";
    public static final String PROFIT_TEMPLATE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 이익이라는 의미임)";
    public static final String LOSS_TEMPLATE = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printTickets(int countOfManual, List<LottoTicketDto> tickets) {
        int countOfAuto = tickets.size() - countOfManual;
        String headerMessage = String.format(TICKET_HEADER_TEMPLATE, countOfManual, countOfAuto);
        System.out.println(headerMessage);
        tickets.forEach(ticket -> System.out.println(ticket.values()));
    }

    public static void printResult(LottoResult lottoResult) {
        System.out.println(RESULT_HEADER);
        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.MISS)
                .forEach(rank -> printRankResult(lottoResult, rank));
    }

    private static void printRankResult(LottoResult lottoResult, LottoRank lottoRank) {
        String prefix = rankMessage(lottoRank);
        int countByRank = lottoResult.getCountByRank(lottoRank);
        String message = String.format(prefix + " - %d개", countByRank);
        System.out.println(message);
    }

    private static String rankMessage(LottoRank lottoRank) {
        int countOfMatch = lottoRank.getCountOfMatch();
        int winningMoney = lottoRank.getWinningMoney();
        if (lottoRank == LottoRank.SECOND) {
            return String.format(RANK_SECOND_RESULT_TEMPLATE, countOfMatch, winningMoney);
        }
        return String.format(RANK_RESULT_TEMPLATE, countOfMatch, winningMoney);
    }

    public static void printProfit(double profitPercent) {
        System.out.println(profitMessage(profitPercent));
    }

    private static String profitMessage(double profitPercent) {
        if (profitPercent < 1.0) {
            return String.format(LOSS_TEMPLATE, profitPercent);
        }
        return String.format(PROFIT_TEMPLATE, profitPercent);
    }
}
