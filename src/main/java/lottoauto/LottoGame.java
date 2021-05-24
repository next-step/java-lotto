package lottoauto;

public class LottoGame {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        LottoGenerateStrategy autoStrategy = new AutoStrategy();

        outputView.enterPurChaseAmount();
        LottoTickets lottoTickets = new LottoTickets(new Money(inputView.nextInt()), autoStrategy);
        outputView.printLottoTickets(lottoTickets);

        outputView.enterWinningNumber();
        LottoNumbers winningNumbers = new LottoNumbers(inputView.next());

        LottoStatement lottoStatement = new LottoStatement();
        lottoTickets.checkHitCount(winningNumbers, lottoStatement);
        outputView.printStatement(lottoStatement);
        outputView.printProceedsRate(lottoTickets.calcProceedsRate(lottoStatement));
    }
}
