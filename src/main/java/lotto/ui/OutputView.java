package lotto.ui;

import lotto.domain.LottoResult;
import lotto.domain.LottoTickets;

public class OutputView {

    private final String REQUEST_INPUT_AMOUNT = "구입금액을 입력해주세요.";
    private final String TOTAL_COUNT_FORMAT = "%d개를 구매했습니다.%n";
    private final String INFO_LOTTO_RESULT = "당첨 통계";
    private final String LINE_DELIMITER = "--------";
    private final String REQUEST_INPUT_WINNING_NUMBERS
            = "구분자(쉼표(,) 혹은 콜론(:))를 이용하여 지난 주 당첨 번호를 입력해 주세요.";
    private final String ERROR_AMOUNT_CANNOT_BE_DIVIDED = "로또 가격(%원)으로 정확히 나누어떨어지는 금액을 입력해주세요.";
    private final String ERROR_AMOUNT_OUT_OF_RANGE = "%d원 이상, %d원 이하의 금액을 입력해주세요.";

    public void printAmountInputRequest() {
        System.out.println(REQUEST_INPUT_AMOUNT);
    }

    public void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(String.format(TOTAL_COUNT_FORMAT, lottoTickets.count()));
        System.out.println(lottoTickets.toString());
    }

    public void printLottoResult(LottoResult result) {
        System.out.println(INFO_LOTTO_RESULT);
        System.out.println(LINE_DELIMITER);
        System.out.println(result.toString());
    }

    public void printWinningNumbersInputRequest() {
        System.out.println(REQUEST_INPUT_WINNING_NUMBERS);
    }
}
