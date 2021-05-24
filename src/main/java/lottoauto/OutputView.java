package lottoauto;

import java.io.PrintStream;

public class OutputView {
    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String TICKETS_COUNT = "%d개를 구매했습니다.";

    private static final String ENTER_LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ENTER_BONUS_NUBER = "보너스 볼을 입력해주세요.";

    private static final String STATEMENT = "당첨 통계\n---------";
    private static final String PROCEEDS_RATE = "총 수익률은 %.2f입니다.";

    private static final PrintStream printStream = System.out;

    public void printf(String format, Object... objects) {
        printStream.printf(format, objects);
        println("");
    }
    public void println(Object object) {
        printStream.println(object);
    }

    public void printStatement(LottoStatement lottoStatement) {
        println(STATEMENT);
        println(lottoStatement.toString());
    }

    public void printLottoTickets(LottoTickets lottoTickets) {
        printf(TICKETS_COUNT, lottoTickets.size());
        println(lottoTickets.toString());
    }

    public void enterPurChaseAmount() {
        println(ENTER_PURCHASE_AMOUNT);
    }

    public void enterWinningNumbers() {
        println(ENTER_LAST_WEEK_WINNING_NUMBER);
    }

    public void printProceedsRate(double proceedsRate) {
        printf(PROCEEDS_RATE, proceedsRate);
    }

    public void enterBonusNumber() {
        println(ENTER_BONUS_NUBER);
    }
}
