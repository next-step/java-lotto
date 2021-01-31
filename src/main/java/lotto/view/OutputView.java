package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.resources.StringResources;
import lotto.utils.StatisticsExporter;

public class OutputView {
    public void printLottoTickets(final LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getPurchaseCount() + "개를 구매했습니다.");
        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            System.out.println(lottoTicket);
        }
    }

    public void printStatistics(final StatisticsExporter statisticsExporter) {
        System.out.println(StringResources.LOTTO_STATISTICS_MESSAGE);
        System.out.println(StringResources.DOTTED_LINE_MESSAGE);
        System.out.println(statisticsExporter.exportStatistics());
        System.out.println(statisticsExporter.exportEarningRate());
    }
}
