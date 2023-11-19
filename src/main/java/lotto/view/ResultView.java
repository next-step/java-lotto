package lotto.view;

import java.io.PrintStream;
import lotto.LottoWallet;
import lotto.StatisticsReport;

public class ResultView {

    private final static String LOTTO_PURCHASE_RESULT_MESSAGE = "%d개를 구매했습니다. \n";

    private final PrintStream sout;

    public ResultView(PrintStream sout) {
        this.sout = sout;
    }
    
    public void calculateResult(int result) {
        sout.printf(LOTTO_PURCHASE_RESULT_MESSAGE, result);
    }

    public void out(LottoWallet lottoWallet) {
        for (int i = 0; i < lottoWallet.totalTicketCount(); i++){
            System.out.println(lottoWallet.oneTicket(i).toString());
        }
    }

    public void out(StatisticsReport statisticsReport) {
        statisticsReport.totalPrize();
    }
}
