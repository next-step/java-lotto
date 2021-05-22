package lotto;

public class OutputView {

    private static final String REQUEST_INPUT_AMOUNT = "구입금액을 입력해주세요.";
    private static final String REQUEST_INPUT_WINNING_NUMBERS
            = "구분자(쉼표(,) 혹은 콜론(:))를 이용하여 지난 주 당첨 번호를 입력해 주세요.";

    public void printAmountInputRequest() {
        System.out.println(REQUEST_INPUT_AMOUNT);
    }

    public void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.toString());
    }

    public void printLottoResult(LottoResult result) {
    }

    public void printWinningNumbersInputRequest() {
        System.out.println(REQUEST_INPUT_WINNING_NUMBERS);
    }
}
