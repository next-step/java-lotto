package lotto.view;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.model.LottoNumber;
import lotto.domain.model.LottoResult;
import lotto.domain.model.LottoRank;
import lotto.domain.model.LottoTicket;
import lotto.domain.model.LottoTickets;

public class ResultView {

    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.printf("%d개를 구매했습니다.\n", lottoTickets.size());
        lottoTickets.getTicketList().forEach(ResultView::printLottoTicket);
    }

    public static void printLottoResult(LottoResult lottoResult) {
        printHeader();
        LottoRank.getPrintableValues()
                .forEach(lottoRank -> printResultByRank(lottoResult, lottoRank));
    }

    private static void printLottoTicket(LottoTicket lottoTicket) {
        Set<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers();
        List<Integer> numbers = lottoNumbers.stream().map(LottoNumber::getLottoNumber)
                .collect(Collectors.toList());
        System.out.println(numbers);
    }

    private static void printResultByRank(LottoResult lottoResult, LottoRank lottoRank) {
        int countMatch = lottoRank.getCountOfMatch();
        int moneyRank = lottoRank.getWinningMoney();
        int countRank = lottoResult.getCountByRank(lottoRank);
        System.out.printf("%d개 일치 (%d원)- %d개\n", countMatch, moneyRank, countRank);
    }

    private static void printHeader() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void printProfitPercent(double profitPercent) {
        String message = String.format("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 ", profitPercent);
        if (profitPercent < 1.0) {
            System.out.println(message + "손해라는 의미임)");
            return;
        }
        System.out.println(message + "이익이라는 의미임)");
    }
}
