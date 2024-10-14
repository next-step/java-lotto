package lotto;

public class LottoDisplay {
    private static final InputView inputView = new InputView();
    private static final Cashier cashier = new Cashier();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        int totalMoney = inputView.inputTotalAmount();
        int totalTicketCount = cashier.makeLottoGamePapers(totalMoney);
        System.out.println(resultView.printTotalLottoTicketCount(totalTicketCount));

    }
}
