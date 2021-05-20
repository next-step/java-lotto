package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;

public class PrintView {

    public static final String BUY_RESULT_MESSAGE = "%d개를 구매했습니다.%n";
    public static final String RESULT_TITLE_MESSAGE = "당첨 통계";
    public static final String DELIMITER_LINE = "---------";
    public static final String PROFIT_RATE_NOTICE_MESSAGE = "총 수익률은 %.2f입니다.";
    public static final String APPEND_MESSAGE_BY_CONDITION = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    public static final int BENEFIT_STANDARD_RATE = 1;

    public void printLottoNumbers(LottoTickets lottoTickets) {
        System.out.printf(BUY_RESULT_MESSAGE, lottoTickets.size());
        System.out.println(lottoTickets);
        System.out.println();
    }

    public void printResult(LottoResult lottoResult, int price) {
        System.out.println();
        System.out.println(RESULT_TITLE_MESSAGE);
        System.out.println(DELIMITER_LINE);
        System.out.print(lottoResult.resultMessage());
        printProfitRate(lottoResult.calculateProfitRate(price));
    }

    private void printProfitRate(double calculateProfitRate) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PROFIT_RATE_NOTICE_MESSAGE, calculateProfitRate));

        if (calculateProfitRate < BENEFIT_STANDARD_RATE) {
            sb.append(APPEND_MESSAGE_BY_CONDITION);
        }
        System.out.println(sb);
    }
}
