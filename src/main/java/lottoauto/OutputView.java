package lottoauto;

import java.io.PrintStream;

public class OutputView {
    private static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ENTER_LAST_WEEK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final PrintStream printStream = System.out;

    private void println(Object object) {
        printStream.println(object);
    }

    public void printStatement(LottoStatement lottoStatement) {
        println("당첨 통계");
        println("---------");
        println(lottoStatement.toString());
    }

    public void printLottoTicket(LottoTicket lottoTicket) {
        println(lottoTicket.toString());
    }

    public void enterPurChaseAmount() {
        println(ENTER_PURCHASE_AMOUNT);
    }

    public void enterWinningNumber() {
        println(ENTER_LAST_WEEK_WINNING_NUMBER);
    }

    public void printLottoTicketsCount(int size) {
        println(size+"개를 구매했습니다.");
    }

    public void printProceedsRate(double proceedsRate) {
        println("총 수익률은 " + proceedsRate + "입니다.");
    }
}
