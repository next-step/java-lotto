package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;

public class PrintView {

    public static final String BUY_RESULT_MESSAGE = "%d개를 구매했습니다.%n";
    public static final String RESULT_TITLE_MESSAGE = "당첨 통계";
    public static final String DELIMITER_LINE = "---------";

    public void printLottoNumbers(LottoTickets lottoTickets) {
        System.out.printf(BUY_RESULT_MESSAGE, lottoTickets.size());
        System.out.println(lottoTickets);
        System.out.println();
    }

    public void printResult(LottoResult lottoResult, int price) {
        System.out.println();
        System.out.println(RESULT_TITLE_MESSAGE);
        System.out.println(DELIMITER_LINE);
        System.out.print(lottoResult.resultMessage(price));
    }
}
