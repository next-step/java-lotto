package lotto.frontend;

import lotto.backend.domain.LottoStatistics;
import lotto.backend.domain.LottoTickets;

public class ResultView {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static void printLottoNumber(LottoTickets lottoTickets) {
        System.out.println(assembleBuyingResult(lottoTickets));
    }

    private static String assembleBuyingResult(LottoTickets LottoTickets) {
        return new StringBuilder().append(LottoTickets.size())
                .append("개를 구매하였습니다.")
                .append(LINE_SEPARATOR)
                .append(LottoTickets.print(LINE_SEPARATOR))
                .toString();
    }

    public static void printLottoResult(LottoStatistics lottoStatistics) {
        System.out.println(assembleLottoResult(lottoStatistics));
    }

    private static String assembleLottoResult(LottoStatistics lottoStatistics) {
        return new StringBuilder()
                .append(LINE_SEPARATOR)
                .append("당첨 통계")
                .append(LINE_SEPARATOR)
                .append("------------------")
                .append(LINE_SEPARATOR)
                .append(assembleMatchResult(lottoStatistics, 3))
                .append(assembleMatchResult(lottoStatistics, 4))
                .append(assembleMatchResult(lottoStatistics, 5))
                .append(assembleMatchResult(lottoStatistics, 6))
                .append(assembleProfit(lottoStatistics))
                .toString();
    }

    private static String assembleMatchResult(LottoStatistics lottoStatistics, int match) {
        return new StringBuilder()
                .append(match)
                .append("개 일치 (")
                .append(lottoStatistics.printPrize(match))
                .append("원)- ")
                .append(lottoStatistics.printMatch(match))
                .append("개")
                .append(LINE_SEPARATOR)
                .toString();
    }

    private static String assembleProfit(LottoStatistics lottoStatistics) {
        return new StringBuilder()
                .append("총 수익률은 ")
                .append(lottoStatistics.printProfit())
                .toString();
    }
}
