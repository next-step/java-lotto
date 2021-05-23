package lottoauto;

public class LottoGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.enterPurChaseAmount();
        User user = new User(new Money(inputView.nextInt()));

        LottoTickets lottoTickets = new LottoTickets();

        user.buyLottoTickets(lottoTickets);
        user.printLottoTickets(outputView);

        outputView.enterWinningNumber();
        LottoNumbers winningNumbers = new LottoNumbers(inputView.next());

        user.checkHitCount(winningNumbers);
        user.printHitCount(outputView);

        user.calcProceedsRate(lottoTickets);
        user.printProceedsRate(outputView);
    }
}
