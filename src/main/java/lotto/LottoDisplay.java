package lotto;

public class LottoDisplay {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        System.out.println(resultView.printTotalLottoTicketCount(inputView.inputTotalAmount()));
    }
}
