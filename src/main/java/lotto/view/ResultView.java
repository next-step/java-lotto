package lotto.view;

import lotto.domain.*;
import lotto.dto.PurchaseResponse;
import lotto.dto.ReportResponse;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String LINE_BREAK = "\n";
    private static final String LOTTO_TICKET_FORMAT = "[%s]";

    private static final String LOTTO_NUMBER_DELIMITER = ", ";

    private static final String REWARD = "당첨 통계";

    private static final String RANK_FORMAT = "%d개 일치 (%s원)- %d개";

    private static final String PROFIT_RATE_FORMAT = "총 수익율은 %.2f 입니다.";

    private static final String PROFIT_RATE_BENEFIT = "(기준이 1을 넘어서 이득임)";

    private static final String PROFIT_RATE_LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void print(final PurchaseResponse purchaseResponse) {
        LottoTickets lottoTickets = purchaseResponse.getLottoTickets();
        String ticketsForm = lottoTickets.getLottoTickets()
                .stream()
                .map(ResultView::lottoTicketForm)
                .collect(Collectors.joining(LINE_BREAK));
        System.out.println(ticketsForm + "\n");
    }

    private static String lottoTicketForm(final LottoTicket lottoTicket) {
        String ticketFrom = lottoTicket.getLottoNumbers()
                .stream()
                .map(LottoNumber::getValue)
                .map(Object::toString)
                .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER));
        return String.format(LOTTO_TICKET_FORMAT, ticketFrom);
    }

    public static void print(final ReportResponse reportResponse) {
        System.out.println(REWARD);
        LottoReport lottoReport = reportResponse.getLottoReport();
        printRanks(getSortedRanks(), lottoReport);
        printProfitRate(lottoReport.profitRate());
    }

    private static List<Rank> getSortedRanks() {
        return Arrays.stream(Rank.values())
                .filter(Rank::isWinning)
                .sorted(Comparator.comparing(Rank::getMatch))
                .collect(Collectors.toList());
    }

    private static void printRanks(final List<Rank> ranks, final LottoReport lottoReport) {
        String ranksForm = ranks.stream()
                .map(rank -> String.format(RANK_FORMAT, rank.getMatch(), rank.getReward(), lottoReport.count(rank)))
                .collect(Collectors.joining(LINE_BREAK));
        System.out.println(ranksForm);
    }

    private static void printProfitRate(final double profitRate) {
        System.out.print(String.format(PROFIT_RATE_FORMAT, profitRate));
        System.out.print(getProfitRateGuide(profitRate));
    }

    private static String getProfitRateGuide(double profitRate) {
        if (profitRate > 1) {
            return PROFIT_RATE_BENEFIT;
        }
        return PROFIT_RATE_LOSS;
    }
}
