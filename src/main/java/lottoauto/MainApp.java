package lottoauto;

public class MainApp {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.enterPurChaseAmount();
        User user = new User(new Money(inputView.nextInt()));

        LottoStore lottoStore = new LottoStore();

        user.buyLottoTickets(lottoStore);
        user.printLottoTickets(outputView);

        outputView.enterWinningNumber();
        LottoNumbers winningNumbers = new LottoNumbers(inputView.next());

        user.checkHitCount(winningNumbers);
        user.printHitCount(outputView);

        user.calcProceedsRate(lottoStore);
        user.printProceedsRate(outputView);
    }
}
