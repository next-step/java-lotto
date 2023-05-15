package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Match;
import lotto.dto.LottoInfo;
import lotto.dto.LottoTicketInfo;

import java.util.List;
import java.util.Set;

public class ResultView {

    private static final String NORMAL_RESULT_FORMAT = "%d개 일치 (%d원)- %d개";
    private static final String BONUS_RESULT_FORMAT = "%d개 일치, 보너스 볼 일치(%d원)- %d개";

    public static void printLottoTicketInfo(LottoTicketInfo ticketInfo) {
        List<LottoInfo> tickets = ticketInfo.getTicketInfo();
        int size = tickets.size();
        System.out.println(size + " 개를 구매했습니다.");
        tickets.forEach(ticket -> System.out.println("[" + String.join(", ", ticket.getLottoInfo()) + "]"));
    }

    public static void printLottoResult(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Match match : Match.values()) {
            printLottoResultForMatch(result, match);
        }
        System.out.println("총 수익률은 " + result.getReturnRate() + "입니다.");
    }

    public static void printLottoResultForMatch(LottoResult result, Match match) {
        if (match.getPrize() == 0) return;
        int prizeCount = result.getMatchCount(match);
        String lottoResultMessage = match.hasBonusNumber()
                ? String.format(BONUS_RESULT_FORMAT, match.getCount(), match.getPrize(), prizeCount)
                : String.format(NORMAL_RESULT_FORMAT, match.getCount(), match.getPrize(), prizeCount);
        System.out.println(lottoResultMessage);
    }
}
